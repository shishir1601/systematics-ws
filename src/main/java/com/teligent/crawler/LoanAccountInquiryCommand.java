package com.teligent.crawler;

import com.jagacy.Key;
import com.jagacy.Session3270;
import com.jagacy.util.JagacyException;
import com.jagacy.util.JagacyProperties;
import com.jagacy.util.Loggable;

public class LoanAccountInquiryCommand extends Session3270 {
	private JagacyProperties props;

	private Loggable logger;

	private String companyName = "";

	public LoanAccountInquiryCommand() throws JagacyException {
		super("crawler");
		props = getProperties();
		logger = getLoggable();
	}

	protected boolean logon() throws JagacyException {
		if (!waitForPosition("logon.wait", "logon.timeout.seconds")) {
			writeKey(Key.CLEAR);
		}

		return true;
	}

	protected void logoff() throws JagacyException {

	}

	public String submitCommand(String accountNumber) throws JagacyException {
		String returnString = "";
		if (!waitForPosition("logon.wait", "logon.timeout.seconds")) {
			writeKey(Key.CLEAR);
		}
		if (!waitForPosition("logon.wait", "logon.timeout.seconds")) {
			writePosition(0, 0, "cssf logoff");
			writeKey(Key.ENTER);
		}
		if (!waitForPosition("logon.wait", "logon.timeout.seconds")) {
			writePosition(19, 5, "H");
			writeKey(Key.ENTER);
		}
		if (!waitForPosition("logon.wait", "logon.timeout.seconds")) {
        	writeKey(Key.CLEAR);
        }
		if (!waitForPosition("logon.wait", "logon.timeout.seconds")) {
			writePosition(0, 0, "tsso");
        	writeKey(Key.ENTER);
        }
		if (!waitForPosition("logon.wait", "logon.timeout.seconds")) {
			writePosition(20, 12, "satt");
        	writeKey(Key.ENTER);
        }
		if (!waitForPosition("logon.wait", "logon.timeout.seconds")) {
			String message = readPosition(23,1,78);
			if(message.contains("F:") || message.contains("E:")){
				if(!waitForPosition("logon.wait", "logon.timeout.seconds")){
					writePosition(21, 56, "Y");
					writeKey(Key.ENTER);
					if(!waitForPosition("logon.wait", "logon.timeout.seconds")){
						writeKey(Key.ENTER);
					}
				}
			}else{
				if(!waitForPosition("logon.wait", "logon.timeout.seconds"))
					writeKey(Key.CLEAR);
			}
        }
		
		if (!waitForPosition("logon.wait", "logon.timeout.seconds")) {
			writePosition(20, 12, "satt");
        	writeKey(Key.CLEAR);
        }
		
		if (!waitForPosition("logon.wait", "logon.timeout.seconds")) {
			writePosition(0, 0, "amai");
        	writeKey(Key.ENTER);
        }
		if (!waitForPosition("logon.wait", "logon.timeout.seconds")) {
			writePosition(2, 37, accountNumber);
			writePosition(2,8,"1");
			writePosition(2,16,"1");
        	writeKey(Key.ENTER);
        }
		if (!waitForPosition("logon.wait", "logon.timeout.seconds")) {
        	String[] array = readScreen();
        	for(int index = 0; index < array.length; ++index){
        		returnString += array[index];
        	}
        }
		
		
		return returnString;
	}
}
