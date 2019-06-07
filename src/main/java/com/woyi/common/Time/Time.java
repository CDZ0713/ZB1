/**
 * @单位名称：和泰通汇—跨境电子商务云平台
 * @Copyright (c) 2014 All Rights Reserved.
 * @系统名称：HTTH-SILOMALL
 * @工程名称：htth.cloud.portal
 * @文件名称: Time.java
 * @类路径: com.htth.silomall.aui.htth
 */

package com.woyi.common.Time;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @see		
 * @author  lizhaoyan@silomall.com
 * @date	2014-8-26 下午2:52:53
 * @version	 
 * @desc    TODO
 */
public class Time {
	/**获取当前系统时间*/
	public static String getTimes(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = sdf.format(new Date());
		return str;
	}
	
	public static  Date getDate(){
		
		Date  date=new Date();
		
		return date;
	}
	
	/**根据传入的日期计算n个月之前或之后的日期
	 * @return String
	 * */
	public static String getNMonthStringTime(String date, int n) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date sDate = sdf.parse(date);
		sDate.setMonth(sDate.getMonth() + n);
		String time = sdf.format(sDate);
		return time;
	}

	/** 根据传入的日期计算n个月之前或之后的日期
	 * @return java.util.Date
	 * */
	public static Date getNMonthDateTime(Date date, int n){
		date.setMonth(date.getMonth() + n);
		return date;
	}
	
	/**java.util.Date时间格式转换String*/
	public static String getDateSwitchStringTimes(Date date){
		String str ="";
		if(date!=null&&!"".equals(date)){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		str = sdf.format(date);
		}
		return str;
	}
}

