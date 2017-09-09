package com.huihuang.util;

import java.text.SimpleDateFormat;

public class DateUtil {
	
	public String getdate(){
		long time=new java.util.Date().getTime();
		String dateTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.sql.Date(time)) ;
		return dateTime;	
	}
}
