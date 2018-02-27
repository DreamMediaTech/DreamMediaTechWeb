package com.dream.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {

	public static String  getTime(){
		
		Date date = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

	public static String getTimeToSecond(){
		Date date = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	 public static String getTomorrowTimeToSecond() {
		 Date date = new Date();
	     Calendar calendar = Calendar.getInstance();
	     calendar.setTime(date);
	     calendar.add(Calendar.DAY_OF_MONTH, +1);//+1今天的时间加一天
	     date = calendar.getTime();
	     SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	     return sdf.format(date);
	    }
}