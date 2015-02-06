package com.pnb.systematics.enterprise;


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
	
	public static String getError(String input){
		String errorMessage = "";
		int index = input.indexOf("F:");
		int index2 = input.indexOf("E:");
		if(index != -1){
			errorMessage.substring(index + 2, index + 20);
		}
		if(index2 != -1){
			errorMessage.substring(index + 2, index +20);
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
			}
		}
		return errorMessage.trim();
			
	}
	
	public static String getFirstTtib(String firstTtib)
	{
		
		
		return firstTtib;	
	}
}