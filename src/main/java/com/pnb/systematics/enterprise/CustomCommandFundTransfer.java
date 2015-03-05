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
 * 
 */
public class CustomCommandFundTransfer extends Session3270 {

    private JagacyProperties props;

    private Loggable logger;

    private String companyName = "";

    public CustomCommandFundTransfer() throws JagacyException {
        super("crawler");
        props = getProperties();
        logger = getLoggable();
    }
    

    /*
     * (non-Javadoc)
     * 
     * @see com.jagacy.Session3270#logon()
     */
    protected boolean logon() throws JagacyException {
        // Notice that you don't have to prefix each property with 'example2'.
        // Jagacy will do this for you.
       if (!waitForPosition("logon.wait", "logon.timeout.seconds")) {
        	writeKey(Key.CLEAR);
        }
    	//System.out.println(new Date().toString());
    //if (waitForPosition(17,7, "ACCOUNT ACCESS", 500)) {
    		//System.out.println("Found Account access");
    	
    	
    	/*waitForChange("logon.timeout.seconds");*/
    	
    	/*if(waitForUnlock(200)){
    		writeKey(Key.CLEAR);
    		waitForUnlock(200);
       }*/
    
        System.out.println("Session log on");
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jagacy.Session3270#logoff()
     */
    protected void logoff() throws JagacyException {
    	
     	//if (!waitForPosition("logon.wait", "logon.timeout.seconds")) {
			
        if(waitForUnlock(200)){
         	writePosition(0, 0, "cssf logoff");
			writeKey(Key.ENTER);
         	}
		//}
     	
    	
    	System.out.println("Session log offf");
    }

 
    public String submitCommand(String command) throws JagacyException{
    	String returnString = ""; 
    	/*if (!waitForPosition("logon.wait", "logon.timeout.seconds")) {
         	writeKey(Key.CLEAR);
         }
    	if (!waitForPosition("logon.wait", "logon.timeout.seconds")) {
        	writePosition(0,0,command);
        	writeKey(Key.ENTER);
         }
     	if (!waitForPosition("logon.wait", "logon.timeout.seconds")) {
     		String[] output = readScreen();
         	for(int index = 0; index < output.length; ++index){
         		returnString += output[index];
         	}
         }
    	*/
    	if (!waitForPosition("logon.wait", "logon.timeout.seconds")) {
        	writeKey(Key.CLEAR);
         }
    	//if(!waitForUnlock(5000)){
    	if (!waitForPosition("logon.wait", "logon.timeout.seconds")) {
        	writePosition(0,0,command);
        	writeKey(Key.ENTER);
         }
    	waitForUnlock(5000);
        	//System.out.println("Sending command");
    	if (!waitForPosition("logon.wait", "logon.timeout.seconds")) {
     		String[] output = readScreen();
         	for(int index = 0; index < output.length; ++index){
         		returnString += output[index];
         	}
         }
     	//if (!waitForPosition("logon.wait", "logon.timeout.seconds")) {
         	writeKey(Key.CLEAR);
         //}
         	//System.out.println("return:  "+returnString);
    		logoff();
    		//System.out.println(new Date().toString());
    	return returnString;
    }
}