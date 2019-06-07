package com.woyi.common;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 
 * 类描述：时间操作定义类
 * 
 * @since 日期：2012-12-8 下午12:15:03
 */
public class DateUtils extends PropertyEditorSupport {
	// 各种时间格式
	public static final SimpleDateFormat date_sdf = new SimpleDateFormat("yyyy-MM-dd");
	// 各种时间格式
	public static final SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	// 各种时间格式
	public static final SimpleDateFormat date_sdf_wz = new SimpleDateFormat("yyyy年MM月dd日");
	public static final SimpleDateFormat time_sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	public static final SimpleDateFormat yyyymmddhhmmss = new SimpleDateFormat("yyyyMMddHHmmss");
	public static final SimpleDateFormat short_time_sdf = new SimpleDateFormat("HH:mm");
	public static final SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	// 以毫秒表示的时间
	private static final long DAY_IN_MILLIS = 24 * 3600 * 1000;
	private static final long HOUR_IN_MILLIS = 3600 * 1000;
	private static final long MINUTE_IN_MILLIS = 60 * 1000;
	private static final long SECOND_IN_MILLIS = 1000;

	// 指定模式的时间格式
	private static SimpleDateFormat getSDFormat(String pattern) {
		return new SimpleDateFormat(pattern);
	}

	/** 获取当前系统时间 */
	public static String getTimes() {
		String str = datetimeFormat.format(new Date());
		return str;
	}

	/**
	 * 当前日历，这里用中国时间表示
	 * 
	 * @return 以当地时区表示的系统当前日历 有测试
	 */
	public static Calendar getCalendar() {
		return Calendar.getInstance();
	}

	/**
	 * 指定毫秒数表示的日历
	 * 
	 * @param millis
	 *            毫秒数
	 * @return 指定毫秒数表示的日历 有测试
	 */
	public static Calendar getCalendar(long millis) {
		Calendar cal = Calendar.getInstance();
		// --------------------cal.setTimeInMillis(millis);
		cal.setTime(new Date(millis));
		return cal;
	}

	/**
	 * 当前日期
	 * 
	 * @return 系统当前时间 没测试
	 */
	public static Date getDate() {
		return new Date();
	}

	/**
	 * 指定毫秒数表示的日期
	 * 
	 * @param millis
	 *            毫秒数
	 * @return 指定毫秒数表示的日期 没测试
	 */
	public static Date getDate(long millis) {
		return new Date(millis);
	}

	/**
	 * 时间戳转换为字符串
	 * 
	 * @param time
	 * @return String
	 * 
	 */
	public static String timestamptoStr(Timestamp time) {
		@SuppressWarnings("unused")
		Date date = null;
		if (null != time) {
			date = new Date(time.getTime());
		}
		return date2Str(date_sdf);
	}

	/**
	 * 字符串转换时间戳
	 * 
	 * @param str
	 * @return Timestamp
	 */
	public static Timestamp str2Timestamp(String str) {
		Date date = str2Date(str, date_sdf);
		return new Timestamp(date.getTime());
	}

	/**
	 * 将符合日期格式的字符串转换成日期类型
	 * 
	 * @param str
	 * @param sdf
	 * @return java.util.date
	 */
	public static Date str2Date(String str, SimpleDateFormat sdf) {
		if (null == str || "".equals(str)) {
			return null;
		}
		Date date = null;
		try {
			date = sdf.parse(str);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 日期转换为字符串
	 * 
	 * @param date_sdf
	 *            日期格式
	 * @return 字符串
	 */
	public static String date2Str(SimpleDateFormat date_sdf) {
		Date date = getDate();
		if (null == date) {
			return null;
		}
		return date_sdf.format(date);
	}

	/**
	 * 格式化时间
	 * 
	 * @param data
	 * @param format
	 * @return String
	 */
	public static String dataformat(String data, String format) {
		SimpleDateFormat sformat = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = sformat.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sformat.format(date);
	}

	/**
	 * 日期转换为字符串
	 * 
	 * @param date
	 *            日期
	 * @param date_sdf
	 *            日期格式
	 * @return 字符串
	 */
	public static String date2Str(Date date, SimpleDateFormat date_sdf) {
		if (null == date) {
			return null;
		}
		return date_sdf.format(date);
	}

	/**
	 * 日期转换为字符串
	 * 
	 * @param format
	 *            日期格式
	 * @return 字符串
	 */
	@SuppressWarnings("unused")
	public static String getDate(String format) {
		Date date = new Date();
		if (null == date) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * 指定毫秒数的时间戳
	 * 
	 * @param millis
	 *            毫秒数
	 * @return 指定毫秒数的时间戳
	 */
	public static Timestamp getTimestamp(long millis) {
		return new Timestamp(millis);
	}

	/**
	 * 以字符形式表示的时间戳
	 * 
	 * @param time
	 *            毫秒数
	 * @return 以字符形式表示的时间戳
	 */
	public static Timestamp getTimestamp(String time) {
		return new Timestamp(Long.parseLong(time));
	}

	/**
	 * 返回系统当前的时间戳
	 * 
	 * @return 系统当前的时间戳
	 */
	public static Timestamp getTimestamp() {
		return new Timestamp(new Date().getTime());
	}

	/**
	 * 指定日期的时间戳
	 * 
	 * @param date
	 *            指定日期
	 * @return 指定日期的时间戳
	 */
	public static Timestamp getTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}

	/**
	 * 返回指定日历的时间戳
	 * 
	 * @param cal
	 *            指定日历
	 * @return 指定日历的时间戳
	 */
	public static Timestamp getCalendarTimestamp(Calendar cal) {
		// ---------------------return new Timestamp(cal.getTimeInMillis());
		return new Timestamp(cal.getTime().getTime());
	}

	// /**
	// * 返回当前时间时间戳
	// * @return 指定日历的时间戳
	// */
	// public static Timestamp gettimestamp() {
	// Date dt = new Date();
	// DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	// String nowTime = df.format(dt);
	// java.sql.Timestamp buydate = java.sql.Timestamp.valueOf(nowTime);
	// return buydate;
	// }

	/**
	 * 系统时间的毫秒数
	 * 
	 * @return 系统时间的毫秒数
	 */
	public static long getMillis() {
		return new Date().getTime();
	}

	/**
	 * 指定日历的毫秒数
	 * 
	 * @param cal
	 *            指定日历
	 * @return 指定日历的毫秒数
	 */
	public static long getMillis(Calendar cal) {
		// --------------------return cal.getTimeInMillis();
		return cal.getTime().getTime();
	}

	/**
	 * 指定日期的毫秒数
	 * 
	 * @param date
	 *            指定日期
	 * @return 指定日期的毫秒数
	 */
	public static long getMillis(Date date) {
		return date.getTime();
	}

	/**
	 * 指定时间戳的毫秒数
	 * 
	 * @param ts
	 *            指定时间戳
	 * @return 指定时间戳的毫秒数
	 */
	public static long getMillis(Timestamp ts) {
		return ts.getTime();
	}

	// ////////////////////////////////////////////////////////////////////////////
	// formatDate
	// 将日期按照一定的格式转化为字符串
	// ////////////////////////////////////////////////////////////////////////////

	/**
	 * 默认方式表示的系统当前日期，具体格式：年-月-日
	 * 
	 * @return 默认日期按“年-月-日“格式显示
	 */
	public static String formatDate() {
		return date_sdf.format(getCalendar().getTime());
	}

	/**
	 * 获取时间字符串
	 */
	public static String getDataString(SimpleDateFormat formatstr) {
		return formatstr.format(getCalendar().getTime());
	}

	/**
	 * 指定日期的默认显示，具体格式：年-月-日
	 * 
	 * @param cal
	 *            指定的日期
	 * @return 指定日期按“年-月-日“格式显示
	 */
	public static String formatDate(Calendar cal) {
		return date_sdf.format(cal.getTime());
	}

	/**
	 * 指定日期的默认显示，具体格式：年-月-日
	 * 
	 * @param date
	 *            指定的日期
	 * @return 指定日期按“年-月-日“格式显示
	 */
	public static String formatDate(Date date) {
		return date_sdf.format(date);
	}

	/**
	 * 指定毫秒数表示日期的默认显示，具体格式：年-月-日
	 * 
	 * @param millis
	 *            指定的毫秒数
	 * @return 指定毫秒数表示日期按“年-月-日“格式显示
	 */
	public static String formatDate(long millis) {
		return date_sdf.format(new Date(millis));
	}

	/**
	 * 默认日期按指定格式显示
	 * 
	 * @param pattern
	 *            指定的格式
	 * @return 默认日期按指定格式显示
	 */
	public static String formatDate(String pattern) {
		return getSDFormat(pattern).format(getCalendar().getTime());
	}

	/**
	 * 指定日期按指定格式显示
	 * 
	 * @param cal
	 *            指定的日期
	 * @param pattern
	 *            指定的格式
	 * @return 指定日期按指定格式显示
	 */
	public static String formatDate(Calendar cal, String pattern) {
		return getSDFormat(pattern).format(cal.getTime());
	}

	/**
	 * 指定日期按指定格式显示
	 * 
	 * @param date
	 *            指定的日期
	 * @param pattern
	 *            指定的格式
	 * @return 指定日期按指定格式显示
	 */
	public static String formatDate(Date date, String pattern) {
		return getSDFormat(pattern).format(date);
	}

	// ////////////////////////////////////////////////////////////////////////////
	// formatTime
	// 将日期按照一定的格式转化为字符串
	// ////////////////////////////////////////////////////////////////////////////

	/**
	 * 默认方式表示的系统当前日期，具体格式：年-月-日 时：分
	 * 
	 * @return 默认日期按“年-月-日 时：分“格式显示
	 */
	public static String formatTime() {
		return time_sdf.format(getCalendar().getTime());
	}

	/**
	 * 指定毫秒数表示日期的默认显示，具体格式：年-月-日 时：分
	 * 
	 * @param millis
	 *            指定的毫秒数
	 * @return 指定毫秒数表示日期按“年-月-日 时：分“格式显示
	 */
	public static String formatTime(long millis) {
		return time_sdf.format(new Date(millis));
	}

	/**
	 * 指定日期的默认显示，具体格式：年-月-日 时：分
	 * 
	 * @param cal
	 *            指定的日期
	 * @return 指定日期按“年-月-日 时：分“格式显示
	 */
	public static String formatTime(Calendar cal) {
		return time_sdf.format(cal.getTime());
	}

	/**
	 * 指定日期的默认显示，具体格式：年-月-日 时：分
	 * 
	 * @param date
	 *            指定的日期
	 * @return 指定日期按“年-月-日 时：分“格式显示
	 */
	public static String formatTime(Date date) {
		return time_sdf.format(date);
	}

	// ////////////////////////////////////////////////////////////////////////////
	// formatShortTime
	// 将日期按照一定的格式转化为字符串
	// ////////////////////////////////////////////////////////////////////////////

	/**
	 * 默认方式表示的系统当前日期，具体格式：时：分
	 * 
	 * @return 默认日期按“时：分“格式显示
	 */
	public static String formatShortTime() {
		return short_time_sdf.format(getCalendar().getTime());
	}

	/**
	 * 指定毫秒数表示日期的默认显示，具体格式：时：分
	 * 
	 * @param millis
	 *            指定的毫秒数
	 * @return 指定毫秒数表示日期按“时：分“格式显示
	 */
	public static String formatShortTime(long millis) {
		return short_time_sdf.format(new Date(millis));
	}

	/**
	 * 指定日期的默认显示，具体格式：时：分
	 * 
	 * @param cal
	 *            指定的日期
	 * @return 指定日期按“时：分“格式显示
	 */
	public static String formatShortTime(Calendar cal) {
		return short_time_sdf.format(cal.getTime());
	}

	/**
	 * 指定日期的默认显示，具体格式：时：分
	 * 
	 * @param date
	 *            指定的日期
	 * @return 指定日期按“时：分“格式显示
	 */
	public static String formatShortTime(Date date) {
		return short_time_sdf.format(date);
	}

	// ////////////////////////////////////////////////////////////////////////////
	// parseDate
	// parseCalendar
	// parseTimestamp
	// 将字符串按照一定的格式转化为日期或时间
	// ////////////////////////////////////////////////////////////////////////////

	/**
	 * 根据指定的格式将字符串转换成Date 如输入：2003-11-19 11:20:20将按照这个转成时间
	 * 
	 * @param src
	 *            将要转换的原始字符窜
	 * @param pattern
	 *            转换的匹配格式
	 * @return 如果转换成功则返回转换后的日期
	 * @throws ParseException
	 * @throws AIDateFormatException
	 */
	public static Date parseDate(String src, String pattern) throws ParseException {
		return getSDFormat(pattern).parse(src);

	}

	/**
	 * 根据指定的格式将字符串转换成Date 如输入：2003-11-19 11:20:20将按照这个转成时间
	 * 
	 * @param src
	 *            将要转换的原始字符窜
	 * @param pattern
	 *            转换的匹配格式
	 * @return 如果转换成功则返回转换后的日期
	 * @throws ParseException
	 * @throws AIDateFormatException
	 */
	public static Calendar parseCalendar(String src, String pattern) throws ParseException {

		Date date = parseDate(src, pattern);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	/**
	 * 给指定的日期增加天数
	 * 
	 * @param src
	 *            指定字符串
	 * @param pattern
	 *            自己需要的模式
	 * @param amount
	 *            需要加的天数
	 * @return 返回String类型。
	 * @throws ParseException
	 */
	public static String formatAddDate(String src, String pattern, int amount) throws ParseException {
		Calendar cal;
		cal = parseCalendar(src, pattern);
		cal.add(Calendar.DATE, amount);
		return formatDate(cal);
	}

	/**
	 * 根据指定的格式将字符串转换成Date 如输入：2003-11-19 11:20:20将按照这个转成时间
	 * 
	 * @param src
	 *            将要转换的原始字符窜
	 * @param pattern
	 *            转换的匹配格式
	 * @return 如果转换成功则返回转换后的时间戳
	 * @throws ParseException
	 * @throws AIDateFormatException
	 */
	public static Timestamp parseTimestamp(String src, String pattern) throws ParseException {
		Date date = parseDate(src, pattern);
		return new Timestamp(date.getTime());
	}

	/**
	 * 计算两个时间之间的差值，根据标志的不同而不同
	 * 
	 * @param flag
	 *            计算标志，表示按照年/月/日/时/分/秒等计算
	 * @param calSrc
	 *            减数
	 * @param calDes
	 *            被减数
	 * @return 两个日期之间的差值
	 */
	@SuppressWarnings("static-access")
	public static int dateDiff(char flag, Calendar calSrc, Calendar calDes) {

		long millisDiff = getMillis(calSrc) - getMillis(calDes);

		if (flag == 'y') {
			return (calSrc.get(calSrc.YEAR) - calDes.get(calDes.YEAR));
		}

		if (flag == 'd') {
			return (int) (millisDiff / DAY_IN_MILLIS);
		}

		if (flag == 'h') {
			return (int) (millisDiff / HOUR_IN_MILLIS);
		}

		if (flag == 'm') {
			return (int) (millisDiff / MINUTE_IN_MILLIS);
		}

		if (flag == 's') {
			return (int) (millisDiff / SECOND_IN_MILLIS);
		}

		return 0;
	}

	/**
	 * 获取当前年
	 * 
	 * @return int
	 */
	public static int getYear() {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(getDate());
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * 获取当前天
	 * 
	 * @return String
	 */
	public static String getDay() {
		SimpleDateFormat date = new SimpleDateFormat("dd");
		return date.format(new Date());
	}

	/**
	 * 获取当前月
	 * 
	 * @return String
	 */
	public static String getMonth() {
		SimpleDateFormat date = new SimpleDateFormat("MM");
		return date.format(new Date());
	}

	/**
	 * 计算2个日期之间相差的天数,用现在的日期减去以前的日期
	 * 
	 * @param now
	 *            现在的时间，格式为yyyy-MM-dd
	 * @param fore
	 *            以前的时间，格式为yyyy-MM-dd
	 * @return long
	 */
	public static long getDayBetween(String now, String fore) {
		long count = 0;

		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date nowDate = myFormatter.parse(now);
			Date foreDate = myFormatter.parse(fore);

			count = (long) (nowDate.getTime() - foreDate.getTime()) / (24 * 60 * 60 * 1000);

		} catch (ParseException e) {
			count = 0;
			e.printStackTrace();
		}

		return count;
	}

	/**
	 * 获取4位当前年
	 * 
	 * @return String
	 */
	public static String getYearYYYY() {
		SimpleDateFormat date = new SimpleDateFormat("yyyy");
		return date.format(new Date());
	}

	/**
	 * 获取当前月的第一天是星期几 0代表星期天
	 * 
	 * @return int
	 */
	public static int getWeekOfThisMonth() {
		Calendar current = Calendar.getInstance();
		current.set(Calendar.DAY_OF_MONTH, 1);
		return current.get(Calendar.DAY_OF_WEEK) - 1;
	}

	/**
	 * 获取当前月共多少天
	 * 
	 * @return int
	 */
	public static int getLastDayOfThisMonth() {
		Calendar cale = Calendar.getInstance();
		int dateOfMonth = cale.getActualMaximum(Calendar.DATE);
		return dateOfMonth;
	}

	/**
	 * 获取当前系统时间的前一天
	 * 
	 * @return String
	 */
	public static String getYestedayDate() {
		Calendar calendar = Calendar.getInstance();// 此时获取的是系统当前时间
		calendar.add(Calendar.DATE, -1); // 得到前一天
		String yestedayDate = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
		return yestedayDate;
	}

	// public static void main(String args[]){
	/*
	 * //这个会打印一些内存中的值，不易观察-----测试1
	 * System.out.println(getCalendar());//这里面会有Asia/Shanghai，当时觉得很神奇啊，从那个文件读的，
	 * jdk？
	 * 
	 * //下面我自己验证的，哈哈，真开心。又能吃三碗饭了。 java.util.Properties p =
	 * System.getProperties(); for (Enumeration e = p.propertyNames();
	 * e.hasMoreElements();) { String key = (String) e.nextElement();
	 * System.out.println(key + ":" + p.getProperty(key)); }
	 */

	/*
	 * //这个是获得毫秒数--------测试2 Calendar cal = Calendar.getInstance(); Long l =
	 * cal.getTimeInMillis(); //如果传一个Long类型的毫秒数
	 * System.out.println(getCalendar(l));
	 */

	// 获得时间戳（并且转化成String类型）
	/*
	 * Timestamp sTimestamp =new Timestamp(System.currentTimeMillis());
	 * System.out.println(System.currentTimeMillis());//1418787997091
	 * System.out.println(sTimestamp);//2014-12-17 11:42:20.58
	 * System.out.println(sTimestamp.getTime());//1418787969042 String
	 * currentTimeString = timestamptoStr(sTimestamp);//转成String类型的了
	 * System.out.println(currentTimeString);//2014-12-17
	 */

	// 字符串转换成时间戳
	/*
	 * Timestamp timestamp =
	 * str2Timestamp("2014-12-17");//必须用这样的样式2014-12-17，因为方法里面写死了
	 * System.out.println(timestamp);
	 */

	// 日期转成字符串,参数是你所需要的类型，展示的样式.
	/*
	 * System.out.println(date2Str(date_sdf));//再方法里面已经设置了时间
	 * System.out.println(date2Str(new Date(),date_sdf));//两个参数，第一个是时间可以自己设定
	 */

	// 格式化时间
	/*
	 * dataformat（String，String）
	 * System.out.println(dataformat("2014-12-17","yyyy-MM-dd"));
	 */

	// 指定毫秒数的时间戳
	/*
	 * System.out.println(getTimestamp(System.currentTimeMillis()));//2014-12-17
	 * 13:25:16.049
	 */

	// 以字符形式表示的时间戳
	/*
	 * System.out.println(getTimestamp(String.valueOf(System.currentTimeMillis()
	 * )));//2014-12-17 13:27:18.166
	 */

	// 系统当前的时间戳
	/*
	 * System.out.println(new Date().getTime());//1418794174511
	 * System.out.println(getTimestamp(new Date().getTime()));//2014-12-17
	 * 13:29:34.511
	 */

	// 指定日期的时间戳
	/*
	 * System.out.println(getTimestamp(new Date()));//2014-12-17 13:31:16.535
	 */

	// 指定日历的时间戳
	/*
	 * System.out.println(getCalendarTimestamp(Calendar.getInstance()));//2014-
	 * 12-17 13:33:43.284
	 * System.out.println(Calendar.getInstance().getTime());//Wed Dec 17
	 * 13:36:03 CST 2014
	 * System.out.println(Calendar.getInstance().getTime().getTime());//
	 * 1418794563879
	 */

	// 系统时间的毫秒数
	/*
	 * System.out.println(new Date().getTime());//1418794668914
	 */

	// 指定日历的毫秒数Calendar.getInstance().getTime()=new Date();
	/*
	 * System.out.println(Calendar.getInstance().getTime().getTime());
	 * //1418794758473
	 */

	// 指定时间戳的毫秒数
	/*
	 * System.out.println(getMillis(new Timestamp(System.currentTimeMillis())));
	 */

	// 如果转换成功则返回转换后的日期(返回Date类型)
	/*
	 * try { System.out.println(parseDate("2003-11-19 11:20:20",
	 * "yyyy-MM-dd HH:mm:ss"));//这是个Date类型的 //System.out.println(parseDate(
	 * "2003-11-19 11:20:20","yyyy-MM-dd HH:mm:ss").getTime());
	 * //System.out.println(parseDate(String.valueOf((new Date())),
	 * "yyyy-MM-dd HH:mm:ss"));//Unparseable date:
	 * "Wed Dec 17 14:19:29 CST 2014" //System.out.println(new
	 * SimpleDateFormat("yyyy-MM-dd").format(new
	 * Date()));//这个是可以的，所以说parse和format的功能还是有区别的 } catch (ParseException e) {
	 * e.printStackTrace(); }
	 */

	// 如果转换成功则返回转换后的日期（返回Calendar类型）
	/*
	 * try { System.out.println(parseCalendar("2014-12-17 14:55:20",
	 * "yyyy-MM-dd HH:mm:ss"));//（返回Calendar类型） } catch (ParseException e) {
	 * e.printStackTrace(); }
	 */

	// 时间差计算两个日期之间的差值
	/*
	 * try {
	 * System.out.println(dateDiff('m',parseCalendar("2014-12-17","yyyy-MM-dd"),
	 * parseCalendar("2014-12-18","yyyy-MM-dd"))); } catch (ParseException e) {
	 * e.printStackTrace(); }
	 */

	// 获得年份
	// System.out.println(getYear());

	// 获得当前几号
	// System.out.println(getDay());

	// 当前几月
	// System.out.println(getMonth());

	// 计算2个日期之间相差的天数,用现在的日期减去以前的日期
	// System.out.println(getDayBetween("2014-12-30","2014-12-14"));

	// 获取当前月的第一天是星期几 .星期天是0哦。亲，五分好评！
	// System.out.println(getWeekOfThisMonth());

	// 获取当前月共多少天
	// System.out.println(getLastDayOfThisMonth());

	// 获取当前系统时间的前一天
	// System.out.println(getYestedayDate());
	// }

}