package com.dengji85.blog.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static final String format = "yyyy-MM-dd HH:mm:ss";
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(format);
	public static String getDateStr(Date date){
		return DATE_FORMAT.format(date);
		
	}
	
	public static String getDateYearStr(Date date){
		SimpleDateFormat f = new SimpleDateFormat("yyyy");
		return f.format(date);
	}
	public static String getDateMouthStr(Date date){
		SimpleDateFormat f = new SimpleDateFormat("MM");
		return f.format(date);
	}
	public static String getDateMouthDateStr(Date date){
		SimpleDateFormat f = new SimpleDateFormat("MM-dd HH:mm");
		return f.format(date);
	}
	
	public static String getDateYearMouthStr(Date date){
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM");
		return f.format(date);
	}

}
