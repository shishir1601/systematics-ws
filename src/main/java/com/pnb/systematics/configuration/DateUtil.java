package com.pnb.systematics.configuration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public String getCurrentHour(){
		DateFormat dateFormat = new SimpleDateFormat("HH");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public String getCurrentSecond(){
		DateFormat dateFormat = new SimpleDateFormat("ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public String getCurrentMinutes(){
		DateFormat dateFormat = new SimpleDateFormat("mm");
		Date date = new Date();
		return dateFormat.format(date);
	}
}
