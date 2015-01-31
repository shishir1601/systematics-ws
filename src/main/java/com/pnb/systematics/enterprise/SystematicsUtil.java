package com.pnb.systematics.enterprise;

public abstract class SystematicsUtil {

	public static String getRealBalance(String balance){
		//get last character
		String operator = balance.charAt(balance.length() - 1) + "";
		
		if(operator.equals("-")){
			return "-" + balance.substring(0, balance.length() - 1).trim();
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
}