package com.pnb.systematics.enterprise;

import java.beans.XMLEncoder;
import java.io.ByteArrayOutputStream;

import org.apache.log4j.Logger;

import com.pnb.systematics.enterprise.bo.impl.SystematicsBusinessObjectImpl;


public abstract class SystematicsUtil {

	public static String getRealBalance(String balance){
		//get last character
		String temp = balance.trim();
		String operator = temp.charAt(temp.length() - 1) + "";
		if(operator.equals("-")){
			return "-" + balance.substring(0, balance.length() - 2).trim();
		}else{
			return balance.substring(0, balance.length() -2);
		}
	}
	
	public static String getNextRecordNumber(int n){
		if((""+n).length()==1){
			return "00"+n;
		}else if((""+n).length()==2){
			return "0"+n;
		}else{
			return ""+n;
		}
	}
	
	public static String getNotNullString(String str){
		if(str==null){
			return "";
		}else{
			return str.trim();
		}
	}
	
	public static String getError(String input){
		String errorMessage = "";
		int index = input.indexOf("F:");
		int index2 = input.indexOf("E:");
		if(index != -1){
			errorMessage.substring(index+2,68);
		}
		if(index2 != -1){
			errorMessage.substring(index+2,68);
			//(index + 2, index + 67);
		}
		return errorMessage;
	}
	
	public static String checkForError(String message){
		String errorMessage = "";
		int index = message.indexOf("E:");
		if(index != -1){
			int found = index;
			index += 2;
			for(; index < message.length() && !(message.substring(index, index + 1).equals("¬")); ++index){
				errorMessage += message.charAt(index);
			}
			errorMessage = errorMessage.trim();
			errorMessage += "|" + message.substring(found - 7,found - 1);
		}else{
			index = message.indexOf("F:");
			if(index != -1){
				int found = index;
				index += 2;
				for(; index < message.length() && !(message.substring(index, index + 1).equals("¬")); ++index){
					errorMessage += message.charAt(index);
				}
				errorMessage = errorMessage.trim();
				errorMessage += "|" + message.substring(found - 7,found - 1);
			}else{
				index = message.indexOf("S:");
				if(index != -1){
					int found = index;
					index += 2;
					for(; index < message.length() && !(message.substring(index, index + 1).equals("¬")); ++index){
						errorMessage += message.charAt(index);
					}
					errorMessage = errorMessage.trim();
					errorMessage += "|" + message.substring(found - 7,found - 1);
				}else{
					index = message.indexOf("O:");
					if(index != -1){
						int found = index;
						index += 2;
						for(; index < message.length() && !(message.substring(index, index + 1).equals("¬")); ++index){
							errorMessage += message.charAt(index);
						}
						errorMessage = errorMessage.trim();
						errorMessage += "|" + message.substring(found - 7,found - 1);
					}
				}
		    }
		}
		return errorMessage.trim();
	}
	
	public static String getWebServiceObject(String hayStack, String needle, int length){
		int index = hayStack.indexOf(needle);
		String returnValue = hayStack.substring(index + needle.length(), index + length + needle.length());
		if(returnValue.contains("-")){
			returnValue = returnValue.substring(0,returnValue.length() - 2);
		}
		return returnValue;
	}
	
	//log every request
	public static void logRequestResponse(Object request, String reqResType){
		ByteArrayOutputStream baos=null;
		XMLEncoder xmlEncoder=null;
		String responseLog="";
		
		if(request!=null){
			
			baos=new ByteArrayOutputStream();
			 xmlEncoder=new XMLEncoder(baos);
			xmlEncoder.writeObject(request);
			xmlEncoder.close();
			 responseLog=baos.toString();
			if(!responseLog.equals("")){
				 Logger logger = Logger.getLogger(SystematicsUtil.class);
				responseLog=responseLog.replaceAll("\n", "").replaceAll("\\<\\?xml(.+?)\\?\\>", "").replaceAll("\\<java(.+?)\\>", "").replaceAll("\\<object(.+?)\\>", "");
				logger.debug(reqResType+":"+responseLog);
			}
			
		}
		 
	}
	
}