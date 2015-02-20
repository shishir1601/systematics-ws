package com.pnb.systematics.enterprise;


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
public class CustomCommand extends Session3270 {

    private JagacyProperties props;

    private Loggable logger;

    private String companyName = "";

    public CustomCommand() throws JagacyException {
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

        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jagacy.Session3270#logoff()
     */
    protected void logoff() throws JagacyException {

    }

 
    public String submitCommand(String command) throws JagacyException{
    	String returnString = ""; 
    	if (!waitForPosition("logon.wait", "logon.timeout.seconds")) {
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
    	return returnString;
    }
}