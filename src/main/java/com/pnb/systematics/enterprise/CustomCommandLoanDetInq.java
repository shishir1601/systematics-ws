package com.pnb.systematics.enterprise;


import java.util.Date;

import com.jagacy.Key;
import com.jagacy.Session3270;
import com.jagacy.util.JagacyException;
import com.jagacy.util.JagacyProperties;
import com.jagacy.util.Loggable;

/**
 * This class uses positions to retrieve the first 5 patents.
 * 
 * @author Robert M. Preston
 * 
 */
public class CustomCommandLoanDetInq extends Session3270 {

    private JagacyProperties props;
    
    private Loggable logger;

    private String companyName = "";

    public CustomCommandLoanDetInq() throws JagacyException {
		super("crawler","10.1.80.75",9995);
		props = getProperties();
		logger = getLoggable();
	}

	protected boolean logon() throws JagacyException {
		System.out.println("Logon: "+new Date().toString());
	if (!waitForPosition("logon.wait", "logon.timeout.seconds")) {
			writeKey(Key.CLEAR);
	}

		return true;
	}

	protected void logoff() throws JagacyException {

		waitForUnlock("loan.timeout.seconds");
		writeKey(Key.CLEAR);
		waitForUnlock("loan.timeout.seconds");
			writePosition(0, 0, "cssf logoff");
        	writeKey(Key.ENTER);
	}

	public String submitCommand(String accountNumber) throws JagacyException {
		String returnString = "";
		waitForUnlock("loan.timeout.seconds");
		writeKey(Key.CLEAR);
		waitForUnlock("loan.timeout.seconds");
		
		System.out.println("write tsso:");
		writePosition(0, 0, "tsso");
        writeKey(Key.ENTER);
       
       	System.out.println("Write satt:");
		waitForUnlock("loan.timeout.seconds");
		writePosition(20, 12, "satt");
        writeKey(Key.ENTER);
		
        System.out.println("read the data:");
		waitForChange("loan.timeout.seconds");
		String message = readPosition(23,0,78);
		waitForUnlock("loan.timeout.seconds");
		
			System.out.println("Message:"+message);
			if(message.contains("F:") || message.contains("E:")){
				System.out.println("wiht f or e:");
					writePosition(21, 56, "Y");
					writeKey(Key.ENTER);
					waitForUnlock("loan.timeout.seconds");
						
				
			}else{
				System.out.println("without f or e:");
					writeKey(Key.CLEAR);
        }
		waitForUnlock("loan.timeout.seconds");
			writePosition(0, 0, "amai");
        	writeKey(Key.ENTER);
		waitForUnlock("loan.timeout.seconds");
			writePosition(2, 37, accountNumber);
			writePosition(2,8,"1");
			writePosition(2,16,"1");
        	writeKey(Key.ENTER);
		waitForUnlock("loan.timeout.seconds");
        	String[] array = readScreen();
        	for(int index = 0; index < array.length; ++index){
        		returnString += array[index];
        	}
        	
        	System.out.println("Logoff: "+new Date().toString());
		return returnString;
		

	}
}