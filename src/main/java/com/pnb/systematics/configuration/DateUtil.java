package com.pnb.systematics.configuration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtil {

	public static String getCurrentHour(){
		DateFormat dateFormat = new SimpleDateFormat("HH");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public static String getCurrentSecond(){
		DateFormat dateFormat = new SimpleDateFormat("ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public static String getCurrentMinutes(){
		DateFormat dateFormat = new SimpleDateFormat("mm");
		Date date = new Date();
		return dateFormat.format(date);
	}
}
