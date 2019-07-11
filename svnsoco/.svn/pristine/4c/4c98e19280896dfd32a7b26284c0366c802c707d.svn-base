package com.soco.car.iot.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DateUtil {

	private static final Log log = LogFactory.getLog(DateUtil.class);

	public static final String DATE_FORMAT = "yyyy-MM-dd";

	public static final String TIME_FORMAT = "HH:mm:ss";

	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static final String DATE_MINUTE_FORMAT = "yyyy-MM-dd HH:mm";

	public static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.S";

	public static final String TIMESTAMP_ALL_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

	public static final String SHORT_MONTH_FORMAT = "yyyyMM";

	public static final String SHORT_DATE_FORMAT = "yyyyMMdd";

	private DateUtil() {
	};

	/**
	 * 功能：计算两个日期之间相差多少天 ((date2-date1)后取整)
	 * 
	 * @param date1
	 *            减日期
	 * @param date2
	 *            被减日期
	 * @return
	 */
	public static int dateDiff(Date date1, Date date2) {
		Calendar calendar1 = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		calendar1.setTime(date1);
		calendar2.setTime(date2);
		calendar1.set(Calendar.HOUR_OF_DAY, 0);
		calendar1.set(Calendar.MINUTE, 0);
		calendar1.set(Calendar.SECOND, 0);
		calendar1.set(Calendar.MILLISECOND, 0);

		calendar2.set(Calendar.HOUR_OF_DAY, 0);
		calendar2.set(Calendar.MINUTE, 0);
		calendar2.set(Calendar.SECOND, 0);
		calendar2.set(Calendar.MILLISECOND, 0);

		long l = Math.abs(calendar2.getTimeInMillis() - calendar1.getTimeInMillis());
		long increaseDate = l / 1000 / 60 / 60 / 24;
		if ((l % (1000 * 60 * 60 * 24)) > 0) {
			increaseDate = increaseDate + 1;
		}
		return (int) increaseDate;
	}

	/**
	 * date2 是否是date1 的下一天
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isNextDay(Date date1, Date date2) {
		Date date3 = DateUtils.addDays(date1, 1);
		return DateUtils.isSameDay(date3, date2);
	}

	/**
	 * 是否同一天
	 * 
	 * @param date1
	 *            日期1
	 * @param date2
	 *            日期2
	 * @return
	 */
	public static boolean isSameDay(Date date1, Date date2) {
		return DateUtils.isSameDay(date1, date2);
	}

	/**
	 * 智能匹配日期格式 格式： yyyy-MM-dd HH:mm:ss yyyy-MM-dd HH:mm:ss.S HH:mm:ss yyyy-MM-dd
	 * yyyyMM yyyyMMdd
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static Date parseStrAutoToDate(String str) {
		DateFormat df = null;
		if (str == null) {
			return null;
		}
		String s = str.replaceAll("/", "-");
		Date d = null;

		if (s.contains(":")) {
			if (s.length() == DATE_TIME_FORMAT.length())
				df = new SimpleDateFormat(DATE_TIME_FORMAT);
			else if (s.length() == TIME_FORMAT.length())
				df = new SimpleDateFormat(TIME_FORMAT);
			else if (s.length() == TIMESTAMP_FORMAT.length())
				df = new SimpleDateFormat(TIMESTAMP_FORMAT);
			else if (s.length() == TIMESTAMP_ALL_FORMAT.length())
				df = new SimpleDateFormat(TIMESTAMP_ALL_FORMAT);
			else if (s.length() == DATE_MINUTE_FORMAT.length())
				df = new SimpleDateFormat(DATE_MINUTE_FORMAT);
		} else if (s.contains("-")) {
			if (s.length() == DATE_FORMAT.length()) {
				df = new SimpleDateFormat(DATE_FORMAT);
			}
		} else {
			if (s.length() == SHORT_DATE_FORMAT.length())
				df = new SimpleDateFormat(SHORT_DATE_FORMAT);
			else if (s.length() == SHORT_MONTH_FORMAT.length())
				df = new SimpleDateFormat(SHORT_MONTH_FORMAT);
			else
				df = new SimpleDateFormat(DATE_FORMAT); // 默认值
		}
		try {
			d = df.parse(s);
		} catch (ParseException e) {
			log.error("ParseException:  " + str + " ,  Exception:" + e);
		}
		return d;
	}

	/**
	 * 是否超过超时 ， 提N前小时
	 * 
	 * date1 > date2+before-->true
	 * 
	 * @param date1
	 * @param date2
	 * @param before
	 * @return
	 */
	public static boolean isOverTime(Date date1, Date date2, int before) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date2);
			calendar.add(Calendar.HOUR, -1 * before);
			// 如果参数 Date 等于此 Date，则返回值 0；
			// 如果此 Date 在 Date 参数之前，则返回小于 0 的值；
			// 如果此 Date 在 Date 参数之后，则返回大于 0 的值。
			if (date1.compareTo(calendar.getTime()) > 0) {
				return true;
			}
		} catch (Exception e) {
			log.error(e);
		}
		return false;
	}

	/**
	 * 功能：判断时间是否是凌晨(0-6),默认当前系统时间
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static boolean isDawn(Date date) throws Exception {
		boolean isDawn = false;
		Calendar tempCal = Calendar.getInstance();
		if (date != null) {
			tempCal.setTime(date);
		}
		int hour = tempCal.get(Calendar.HOUR_OF_DAY);
		if (0 <= hour && hour < 6) {// 不包含6点
			isDawn = true;
		}
		return isDawn;
	}

	/**
	 * 功能：根据传入的字符串，得到holdTime， 得到的时间为1970年的HH:mm:ss
	 * 如果格式不对(不为例如:23:12:23或着23:56或着23)，抛出异常
	 * 
	 * @param str
	 * @return
	 */
	public static Date getHoldTimeDate(String str) throws Exception {
		boolean flag = false;
		Pattern p1 = Pattern.compile("(0\\d{1}|1\\d{1}|2[0-3]):[0-5]\\d{1}:([0-5]\\d{1})");
		Matcher m1 = p1.matcher(str);
		Pattern p2 = Pattern.compile("(0\\d{1}|1\\d{1}|2[0-3])");
		Matcher m2 = p2.matcher(str);
		Pattern p3 = Pattern.compile("(0\\d{1}|1\\d{1}|2[0-4]):[0-5]\\d{1}");
		Matcher m3 = p3.matcher(str);
		if (m1.matches() || m2.matches() || m3.matches()) {
			flag = true;
			if (m3.matches()) {
				return parseStrToDate(str, "HH:mm");
			}
			if (m1.matches()) {
				return parseStrToDate(str, "HH:mm:ss");
			}

			if (m2.matches()) {
				return parseStrToDate(str, "HH");
			}
		}

		if (!flag) {
			throw new IllegalArgumentException("holdTime format is invalid!");
		}
		return null;
	}

	/**
	 * 日期转为HoldTime格式HH:mm
	 * 
	 * @param date
	 * @return
	 */
	public static String date2Holdtime(Date date) {
		if (date == null)
			return "";
		SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm");
		return dateformat.format(date);
	}

	/**
	 * 功能：获取yyyyMM的年月
	 * 
	 * @param date
	 * @return
	 */
	public static String getShortMonth(Date date) {
		SimpleDateFormat df = new SimpleDateFormat(SHORT_MONTH_FORMAT);
		return df.format(date);
	}

	/**
	 * 功能：获取yyyyMMdd的年月日
	 * 
	 * @param date
	 * @return
	 */
	public static String getShortDate(Date date) {
		SimpleDateFormat df = new SimpleDateFormat(SHORT_DATE_FORMAT);
		return df.format(date);
	}

	/**
	 * 功能：根据一个日期，算出是这个月中的第几天
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayOfMonth(Date date) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date);
		return cal1.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 功能：取出一个月中某天的日期
	 * 
	 * @param month
	 * @param num
	 * @return
	 */
	public static Date dateOfMonthByNum(String month, int num) {
		Calendar cl = Calendar.getInstance();
		cl.setTime(parseStrAutoToDate(month));
		cl.set(Calendar.HOUR_OF_DAY, 0);
		cl.set(Calendar.MINUTE, 0);
		cl.set(Calendar.SECOND, 0);
		cl.set(Calendar.MILLISECOND, 0);
		cl.add(Calendar.DAY_OF_YEAR, num - 1);
		return cl.getTime();
	}

	/**
	 * 功能：得到本周第一天日期
	 * 
	 * @return
	 */
	public static Date currentWeekMonday() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		int index = cal.get(Calendar.DAY_OF_WEEK);
		// 转成中国的习惯,如果是第一天,则转化为第七天(星期天外国为一周的第一天,而中国为每周的最后一天)
		if (index == 1)
			index = 8;
		cal.add(Calendar.DATE, -(index - 2));
		return cal.getTime();

	}

	/**
	 * 功能：得到本周最后一天的日期
	 * 
	 * @return
	 */
	public static Date currentWeekSaturday() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		int index = cal.get(Calendar.DAY_OF_WEEK);
		if (index == 1)
			index = 8;
		cal.add(Calendar.DATE, -(index - 2));
		cal.add(Calendar.DATE, 6);
		return cal.getTime();
	}

	/**
	 * 功能：从指定日期DAY移动一定的天数 ，时分秒都是0
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date moveDay(Date date, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(Calendar.DAY_OF_MONTH, day);
		return cal.getTime();
	}

	/**
	 * 功能：从当天日期移动一定的月数
	 * 
	 * @param month
	 * @return
	 */

	public static Date getMoveMonthDate(int month) {
		Date nowDate = new Date();
		Calendar cl = Calendar.getInstance();
		cl.setTime(nowDate);
		cl.add(Calendar.MONDAY, month - 1);
		Date date1 = cl.getTime();
		return date1;
	}

	/**
	 * 功能：获取昨天 DATE_FORMAT
	 * 
	 * @return
	 */
	public static Date getYesterday() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		return cal.getTime();
	}

	/**
	 * 功能：根据某个日期，返回本月第一天
	 * 
	 * @param date
	 *            任何一天
	 * @return Date 当月第一天
	 */
	public static Date getMonthsFirstDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 功能：根据某个日期，返回本月最后一天
	 * 
	 * @param date
	 *            任何一天
	 * @return Date 当月第一天
	 */
	public static Date getMonthsLastDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(Calendar.MONTH, 1);
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}

	/**
	 * 功能：获取起始日期和终止日期之间的日期(包含起始和终止日期)
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static Set<String> getDayList(Date startDate, Date endDate) {
		long begin = startDate.getTime();
		long end = endDate.getTime();
		long inter = end - begin;
		if (inter < 0) {
			inter = inter * (-1);
		}
		long dateMillSec = 86400000;
		long dateCnt = inter / dateMillSec;
		Set<String> set = new LinkedHashSet<String>();
		Calendar cl = Calendar.getInstance();
		cl.setTime(startDate);
		cl.set(Calendar.HOUR_OF_DAY, 0);
		cl.set(Calendar.MINUTE, 0);
		cl.set(Calendar.SECOND, 0);
		cl.set(Calendar.MILLISECOND, 0);
		set.add(getShortDate(cl.getTime()));
		for (int i = 1; i <= dateCnt; i++) {
			cl.add(Calendar.DAY_OF_YEAR, 1);
			set.add(getShortDate(cl.getTime()));
		}
		set.add(getShortDate(endDate));
		return set;
	}

	/**
	 * 功能：取得两个日期中最小的日期,如果两个日期参数都为null则返回null
	 * 
	 * @param date1
	 * @param date2
	 * @return Date or null
	 */
	public static Date getMinimizeDate(Date date1, Date date2) {
		if (date1 == null) {
			return date2;
		}
		if (date2 == null) {
			return date1;
		}
		if (date1.compareTo(date2) > 0) {
			return date2;
		}
		return date1;
	}

	/**
	 * 功能：取得两个日期中最大的日期,如果两个日期参数都为null则返回null
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static Date getMaxmizeDate(Date date1, Date date2) {
		if (date1 == null) {
			return date2;
		}
		if (date2 == null) {
			return date1;
		}
		if (date1.compareTo(date2) < 0) {
			return date2;
		}
		return date1;
	}

	/**
	 * 功能：获取指定日期和天数的星期几
	 * 
	 * @param date
	 *            指定日期
	 * @param day
	 *            指定天数
	 * @return
	 */
	public static int getDayofWeek(Date date, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + day - 1);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 功能：把date1的小时，分钟，秒换成date2的小时，分钟，秒,返回换值后的date1
	 * 
	 * @param date1
	 * @param time2
	 * @return
	 */
	public static Date mergeDate1AndTime2(Date date1, Date time2) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);

		Calendar cl2 = Calendar.getInstance();
		cl2.setTime(time2);
		cal.set(Calendar.HOUR_OF_DAY, cl2.get(Calendar.HOUR_OF_DAY));
		cal.set(Calendar.MINUTE, cl2.get(Calendar.MINUTE));
		cal.set(Calendar.SECOND, cl2.get(Calendar.SECOND));

		return cal.getTime();
	}

	/**
	 * 功能：把date1的小时，分钟，秒换成23:59:59
	 * 
	 * @param date1
	 * @return yyyy-MM-dd 23:59:59
	 */
	public static Date getDayOfMaxHourMinuteSecond(Date date1) {
		Calendar cl1 = Calendar.getInstance();
		cl1.setTime(date1);
		cl1.set(Calendar.HOUR_OF_DAY, 23);
		cl1.set(Calendar.MINUTE, 59);
		cl1.set(Calendar.SECOND, 59);

		return cl1.getTime();
	}

	/**
	 * 功能：对日期进行格式化输出
	 * 
	 * @param date
	 *            日期
	 * @param format
	 * @return
	 */
	public static String formatDate(Date date, String format) {
		try {
			if (format != null && !"".equals(format) && date != null) {
				SimpleDateFormat formatter = new SimpleDateFormat(format);
				return formatter.format(date);
			}
		} catch (Exception e) {
			return "";
		}
		return "";
	}

	/**
	 * 功能：把日期字符串格式化为日期类型
	 * 
	 * @param datetext
	 *            日期字符串
	 * @param format
	 *            日期格式，如果不传则使用"yyyy-MM-dd HH:mm:ss"格式
	 * @return
	 */
	public static Date parseStrToDate(String datetext, String format) {
		Date date = null;
		try {
			SimpleDateFormat df;
			if (StringUtils.isBlank(datetext)) {
				return null;
			}
			if (StringUtils.isNotBlank(format)) {
				df = new SimpleDateFormat(format);
			} else {
				datetext = datetext.replaceAll("/", "-");
				df = new SimpleDateFormat(DATE_TIME_FORMAT);
			}
			date = df.parse(datetext);
		} catch (Exception e) {
		}
		return date;
	}

	/**
	 * Adds a number of days to a date returning a new object. The original date
	 * object is unchanged.
	 * 
	 * @param date
	 *            the date, not null
	 * @param amount
	 *            the amount to add, may be negative
	 * @return the new date object with the amount added
	 * @throws IllegalArgumentException
	 *             if the date is null
	 */
	public static Date addDay(Date date, int amount) {
		return DateUtils.addDays(date, amount);
	}

	/**
	 * 功能： 添加Minute
	 * 
	 * @param cdate
	 * @param amount
	 * @return
	 */
	public static Date addMinute(Date cdate, int amount) {
		Calendar cl = Calendar.getInstance();
		cl.setTime(cdate);
		cl.add(Calendar.MINUTE, amount);
		return cl.getTime();
	}

	/**
	 * 功能： 添加Second
	 * 
	 * @param cdate
	 * @param amount
	 * @return
	 */
	public static Date addSecond(Date cdate, int amount) {
		Calendar cl = Calendar.getInstance();
		cl.setTime(cdate);
		cl.add(Calendar.SECOND, amount);
		return cl.getTime();
	}

	/**
	 * 功能： 添加Hour
	 * 
	 * @param cdate
	 * @param amount
	 * @return
	 */
	public static Date addHour(Date date, int amount) {
		return DateUtils.addHours(date, amount);
	}

	/**
	 * 功能： 添加Year
	 * 
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date addYear(Date date, int amount) {
		return DateUtils.addYears(date, amount);
	}

	/**
	 * 添加Month
	 * 
	 * @param cdate
	 * @param amount
	 * @return
	 */
	public static Date addMonth(Date date, int amount) {
		return DateUtils.addMonths(date, amount);
	}

	/**
	 * 功能：获取两个日期之间的天数
	 * 
	 * @param dateFrom
	 *            起始日期
	 * @param dateEnd
	 *            结束日期
	 * @return
	 */
	public static long betweenTwoDatesMath(String dateFrom, String dateEnd) {
		Date dtFrom = parseStrAutoToDate(dateFrom);
		;
		Date dtEnd = parseStrAutoToDate(dateEnd);
		long begin = dtFrom.getTime();
		long end = dtEnd.getTime();
		long inter = end - begin;
		long dateMillSec = 24 * 60 * 60 * 1000;
		long dateCnt = inter / dateMillSec;
		long remainder = inter % dateMillSec;
		if (remainder != 0) {
			dateCnt++;
		}
		return dateCnt;
	}

	/**
	 * 返回两个日期间的 日期数组
	 * 
	 * @param dateFrom
	 * @param dateEnd
	 * @return
	 */
	public static Date[] betweenTwoDayArray(Date dateFrom, Date dateEnd) {
		int i = DateUtil.dateDiff(dateFrom, dateEnd);
		if (i < 0) {
			throw new IllegalArgumentException("dateFrom must before dateEnd!");
		}
		Date dates[] = new Date[i + 1];
		Date d = DateUtil.parseStrAutoToDate(DateUtil.formatDate(dateFrom));
		for (int j = 0; j < dates.length; j++) {
			dates[j] = DateUtil.addDay(d, j);
		}
		return dates;
	}

	public static List<Date> betweenTwoDayMonthArray(Date dateFrom, Date dateEnd) {
		if (dateFrom.after(dateEnd)) {
			throw new IllegalArgumentException("dateFrom must before dateEnd!");
		}

		List<Date> dates = new ArrayList<Date>();
		Date d = DateUtil.rollMonth(dateFrom, 0);
		while (!d.after(dateEnd)) {
			dates.add(d);
			d = addMonth(d, 1);
		}
		return dates;
	}

	/**
	 * 返回两个日期间的 日期数组
	 * 
	 * @param dateFrom
	 * @param dateEnd
	 * @return
	 */
	public static String[] betweenTwoDayArrayString(Date dateFrom, Date dateEnd) {
		int i = DateUtil.dateDiff(dateFrom, dateEnd);
		if (i < 0) {
			throw new IllegalArgumentException("dateFrom must before dateEnd!");
		}
		String dates[] = new String[i + 1];
		Date d = DateUtil.parseStrAutoToDate(DateUtil.formatDate(dateFrom));
		for (int j = 0; j < dates.length; j++) {
			dates[j] = DateUtil.formatDate(DateUtil.addDay(d, j));
		}
		return dates;
	}

	/**
	 * 功能：获取星期几 SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, and SATURDAY
	 * 
	 * @param date
	 * @return
	 */
	public static int getWeekByDate(Date date) {
		Calendar cl1 = Calendar.getInstance();
		cl1.setTime(date);
		cl1.set(Calendar.HOUR_OF_DAY, 0);
		cl1.set(Calendar.MINUTE, 0);
		cl1.set(Calendar.SECOND, 0);
		return cl1.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 日期转字符串，输出格式 "yyyy-MM-dd"
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
			return formatter.format(date);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 功能：根据某个日期，返回本月的天数 Calendar.DAY_OF_MONTH
	 * 
	 * @param date
	 *            本月任何一天
	 * @return 天数
	 */
	public static int getMonthsMaxDay(Date date) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date);
		return cal1.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 功能：根据某个日期，返回本月的所有日期数组
	 * 
	 * @param date
	 *            给定日期
	 * @return 本月的所有日期数组
	 */
	public static Date[] getOneMonthsDayArray(Date date) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date);
		cal1.set(Calendar.DATE, 1);

		int dayTimes = cal1.getActualMaximum(Calendar.DAY_OF_MONTH);
		Date[] dataArray = new Date[dayTimes];

		for (int i = 0; i < dayTimes; i++) {
			dataArray[i] = cal1.getTime();
			cal1.setTime(DateUtils.addDays(dataArray[i], 1));
		}
		return dataArray;
	}

	/**
	 * 功能：根据某个日期，返回monthNum个月的第一天数组
	 * 
	 * @param date
	 *            开始日期
	 * @param monthNum
	 *            月份个数
	 * @return 每个月的第一天数组
	 */
	public static Date[] getXMonthsFirstDayArray(Date date, int monthNum) {
		Date[] dataArray = new Date[monthNum];
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date);
		cal1.set(Calendar.DATE, 1);
		for (int i = 0; i < monthNum; i++) {
			dataArray[i] = addMonth(cal1.getTime(), i);
		}

		return dataArray;
	}

	/**
	 * 功能：根据1个日期，返回上N个月的第一天
	 * 
	 * @param date
	 *            日期
	 * @param month
	 *            上N月
	 * @return 上N个月的第一天
	 */
	public static Date rollMonth(Date date, int month) {
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.set(Calendar.DATE, 1);
			cal.roll(Calendar.MONTH, month);
			return cal.getTime();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String getDateTime() {
		Date dateTime = new Date();
		SimpleDateFormat format = new SimpleDateFormat(DATE_TIME_FORMAT);
		String strTime = format.format(dateTime);
		return strTime;
	}

	/**
	 * Get the date of monday in this week
	 * 
	 * @return yyyy-MM-dd
	 */
	public static String getMondayOfThisWeek() {
		String strTemp = "";
		Calendar c = Calendar.getInstance();
		int dayofweek = c.get(Calendar.DAY_OF_WEEK) - 1;
		if (dayofweek == 0)
			dayofweek = 7;
		c.add(Calendar.DATE, -dayofweek + 1);
		strTemp = c.get(1) + "-";
		if (c.get(2) + 1 < 10)
			strTemp += "0";
		strTemp = strTemp + (c.get(2) + 1) + "-";
		if (c.get(5) < 10)
			strTemp += "0";
		strTemp += c.get(5);
		return strTemp;
	}

	/**
	 * Get the date of sunday in this week
	 * 
	 * @return yyyy-MM-dd
	 */
	public static String getSundayOfThisWeek() {
		String strTemp = "";
		Calendar c = Calendar.getInstance();
		int dayofweek = c.get(Calendar.DAY_OF_WEEK) - 1;
		if (dayofweek == 0)
			dayofweek = 7;
		c.add(Calendar.DATE, -dayofweek + 7);
		strTemp = c.get(1) + "-";
		if (c.get(2) + 1 < 10)
			strTemp += "0";
		strTemp = strTemp + (c.get(2) + 1) + "-";
		if (c.get(5) < 10)
			strTemp += "0";
		strTemp += c.get(5);
		return strTemp;
	}

	/**
	 * Get the date of AfterDays
	 * 
	 * @param day
	 * @return yyyy-MM-dd
	 */
	public static String getTheDayAfterDays(int day) {
		String strTemp = "";
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, day);
		strTemp = c.get(1) + "-";
		if (c.get(2) + 1 < 10)
			strTemp += "0";
		strTemp = strTemp + (c.get(2) + 1) + "-";
		if (c.get(5) < 10)
			strTemp += "0";
		strTemp += c.get(5);
		return strTemp;
	}

	/**
	 * Get date time in yyyy年MM月dd日hh:mm:ss format
	 * 
	 * @return String sb
	 */
	public static String getDateTimeCN() {
		StringBuffer stringbuffer = new StringBuffer();
		Calendar calendar = Calendar.getInstance();
		stringbuffer.setLength(0);
		stringbuffer.append(calendar.get(1));
		stringbuffer.append('年');
		stringbuffer.append(calendar.get(2) + 1);
		stringbuffer.append('月');
		stringbuffer.append(calendar.get(5));
		stringbuffer.append('日');
		stringbuffer.append(calendar.get(11));
		stringbuffer.append(':');
		if (calendar.get(12) < 10)
			stringbuffer.append(0);
		stringbuffer.append(calendar.get(12));
		stringbuffer.append(':');
		if (calendar.get(13) < 10)
			stringbuffer.append(0);
		stringbuffer.append(calendar.get(13));
		return stringbuffer.toString();
	}

	/**
	 * Get date time in Hashmap
	 * 
	 * @return a HashMap
	 */
	public static Map<String, Integer> getDateTimeToHashMap() {
		Map<String, Integer> hpDt = new HashMap<String, Integer>();
		Calendar cal = Calendar.getInstance();
		hpDt.put("YEAR", new Integer(cal.get(Calendar.YEAR)));
		hpDt.put("MONTH", new Integer(cal.get(Calendar.MONTH) + 1));
		hpDt.put("DAY", new Integer(cal.get(Calendar.DAY_OF_MONTH)));
		hpDt.put("HOUR", new Integer(cal.get(Calendar.HOUR_OF_DAY)));
		hpDt.put("MINUTE", new Integer(cal.get(Calendar.MINUTE)));
		hpDt.put("SECOND", new Integer(cal.get(Calendar.SECOND)));
		return hpDt;
	}

	/**
	 * Format time 2005-10-08 10:03:41.0 to 2005-10-08 10:03:41 .
	 * 
	 * @param str
	 *            the time string
	 * @return String
	 */
	public static String timeStampToTime(String str) {
		str = (str == null) ? "" : str;
		String strTemp = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '.') {
				break;
			}
			strTemp += str.charAt(i);
		}
		return strTemp;
	}

	public static String getFormatDate(String str) {
		str = (str == null) ? "" : str;
		String strTemp = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				break;
			}
			strTemp += str.charAt(i);
		}
		return strTemp;
	}

	/**
	 * Day DATE 是否在日期范围内， 包含FROM,TO , 不比较时分秒
	 * 
	 * @param availDate
	 * @param indateFrom
	 * @param indateTo
	 * @return
	 */
	public static boolean isInDayRange(Date availDate, Date indateFrom, Date indateTo) {
		Calendar c = Calendar.getInstance();
		c.setTime(availDate);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		if (indateFrom != null) {
			Calendar c1 = Calendar.getInstance();
			c1.setTime(indateFrom);
			c1.set(Calendar.HOUR_OF_DAY, 0);
			c1.set(Calendar.MINUTE, 0);
			c1.set(Calendar.SECOND, 0);
			c1.set(Calendar.MILLISECOND, 0);
			if (c.before(c1))
				return false;
		}
		if (indateTo != null) {
			Calendar c2 = Calendar.getInstance();
			c2.setTime(indateTo);
			c2.set(Calendar.HOUR_OF_DAY, 0);
			c2.set(Calendar.MINUTE, 0);
			c2.set(Calendar.SECOND, 0);
			c2.set(Calendar.MILLISECOND, 0);
			if (c.after(c2))
				return false;
		}

		return true;
	}

	/**
	 * 获取今天日期
	 * 
	 * @return
	 */
	public static Date getToday() {
		Calendar curDate = Calendar.getInstance();
		curDate.set(Calendar.HOUR_OF_DAY, 0);
		curDate.set(Calendar.MINUTE, 0);
		curDate.set(Calendar.SECOND, 0);
		curDate.set(Calendar.MILLISECOND, 0);

		return curDate.getTime();
	}

}
