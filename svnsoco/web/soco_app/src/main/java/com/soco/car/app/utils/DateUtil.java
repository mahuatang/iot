package com.soco.car.app.utils;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class DateUtil {
	
	// 日志记录器
	static Logger log = Logger.getLogger(DateUtil.class);
	
	/*********************************************************************
	 * 
	 * 日期格式
	 * 
	 */
	public static String DATE_FORMATE_1 = "yyyy-MM-dd HH:mm:ss";
	public static String DATE_FORMATE_1_TRIM = "yyyy-MM-ddHH:mm:ss";
	public static String DATE_FORMATE_2 = "yyyy-MM-dd";
	public static String DATE_FORMATE_3 = "yyMMdd";
	public static String DATE_FORMATE_4 = "yyyyMMdd";
	public static String DATE_FORMATE_5 = "yyyyMM";
	public static String DATE_FORMATE_6 = "yy";
	
	

	/**********************************************************************
	 * 
	 * 根据指定时间格式，返回当前（String）格式时间
	 * 
	 */
	public static String getCurrentDate(String current) throws Exception {
		SimpleDateFormat formatDate = new SimpleDateFormat(current);
		String str = formatDate.format(new Date());
		try {
			String date = formatDate.format(formatDate.parse(str));
			return date;
		} catch (ParseException e) {
			log.error("【日期工具】根据指定时间格式，返回当前（String）格式时间", e);
			return "";
		}
	}

	
	
	/**********************************************************************
	 * 
	 * 根据指定时间格式，返回指定时间（Data）格式时间
	 * 
	 */
	public static Date stringConvetDate(String time, String current) {
		SimpleDateFormat formatDate = new SimpleDateFormat(current);
		Date date = null;

		try {
			if (time != null) {
				date = formatDate.parse(time);
			}
		} catch (ParseException e) {
			log.error("【日期工具】根据指定时间格式，返回指定时间（Data）格式时间", e);
		}

		return date;
	}
	
	
	/**********************************************************************
	 * 
	 * 根据指定时间格式，返回指定时间（String）格式时间
	 * 
	 */
	public static String dateConvetString(Date d, String current) {
		SimpleDateFormat formatDate = new SimpleDateFormat(current);
		String str = formatDate.format(d);
		try {
			String date = formatDate.format(formatDate.parse(str));
			return date;
		} catch (ParseException e) {
			log.error("【日期工具】根据指定时间格式，返回指定时间（String）格式时间", e);
			return "";
		}

	}



	// 判断瑞年还是平年
	public static Boolean JudgeYear(Integer year) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			return true;
		} else {
			return false;
		}
	}

	// 判断日期是该年的第几天
	public static Integer getCurrentDay(String date) {
		Date date1 = DateUtil.stringConvetDate(date, "yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		return cal.get(Calendar.DAY_OF_YEAR);
	}


	public static Calendar stringToCalendar(String date) throws Exception {
		Calendar cal = Calendar.getInstance();
		Date date2 = stringConvetDate(date, "yyyy-MM-dd");
		cal.setTime(date2);
		return cal;
	}

	

	/**
	 * 输入日期和天数得到对应天数后的日期
	 */
	public static Date addDate(Date d, long day) throws ParseException {
		long time = d.getTime();
		day = day * 24 * 60 * 60 * 1000;
		time += day;
		return new Date(time);
	}
	
	public static Integer getSeconds(long oldTime) throws Exception{
		long newTime = new Date().getTime();
		if(oldTime > newTime){
			return -1;
		}
		Integer seconds = (int) ((newTime-oldTime)/1000);
		return seconds;
		
	}
	
	/**
	 * 产生随机的六位数
	 * @return
	 */
	public static String getRandoForSix(){
		return (int)(Math.random()*899999+100000)+"";
	}
	
	
	/**********************************************************************
	 * 
	 * 生成随机订单编号，用户ID参与计算
	 * 
	 */
	public static String createOrderNo(Integer userId){
		String longTime = System.currentTimeMillis()+"";
		String randStr = getRandoForSix();
		String str = MD5Util.MD5(longTime+randStr+userId+getRandoForSix()+System.currentTimeMillis()+getRandoForSix());
		return str.substring(9, 25);
	}
	
	
	public static long getDaySub(String beginDateStr,String endDateStr){
		long day=0;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate;
		Date endDate;
		try{
			beginDate = format.parse(beginDateStr);
			endDate= format.parse(endDateStr); 
			day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000); 
		} catch (ParseException e){
			e.printStackTrace();
		} 
		return day;
	}
	
	
	public static Date parseYYYYMMDDHH(String dateStr) {
		SimpleDateFormat ft=null;
		try {
			ft = new SimpleDateFormat("yyyy-MM-dd HH");
			return ft.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Date parseYYYYMMDD(String dateStr){
		SimpleDateFormat ft = null;
		try {
			ft = new SimpleDateFormat("yyyy-MM-dd");
			return ft.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Date parseYYYYMM(String dateStr){
		SimpleDateFormat ft = null;
		try {
			ft = new SimpleDateFormat("yyyy-MM");
			return ft.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String formatYYYYMMDDHH(Date date) {
		SimpleDateFormat ft=null;
		try {
			ft = new SimpleDateFormat("yyyy-MM-dd HH");
			return ft.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String formatYYYYMMDD(Date date){
		SimpleDateFormat ft = null;
		try {
			ft = new SimpleDateFormat("yyyy-MM-dd");
			return ft.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String formatYYYYMM(Date date){
		SimpleDateFormat ft = null;
		try {
			ft = new SimpleDateFormat("yyyy-MM");
			return ft.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String format(Date date,String format){
		SimpleDateFormat ft = null;
		try {
			ft = new SimpleDateFormat(format);
			return ft.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static Date parse(String dateStr,String format) {
		SimpleDateFormat ft=null;
		try {
			ft = new SimpleDateFormat("yyyy-MM-dd HH");
			return ft.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static Date defaultParse(String dateStr,String format) {
		SimpleDateFormat ft=null;
		try {
			ft = new SimpleDateFormat(format);
			return ft.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取当前系统的时间戳
	 *
	 * @return
	 */
	public static String getCurrentTimestamp() {

		long timeStamp = new Date().getTime();
		return String.valueOf(timeStamp);
	}

	public static String getCurrentTimestamp10() {

		long timeStamp = new Date().getTime() / 1000;
		String timestr = String.valueOf(timeStamp);
		return timestr;
	}

	public static String getTimeStamp() {
		int time = (int) (System.currentTimeMillis() / 1000);
		return String.valueOf(time);
	}
}
