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
}