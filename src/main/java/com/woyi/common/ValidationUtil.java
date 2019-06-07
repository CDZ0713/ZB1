package com.woyi.common;

import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 验证工具类
 * 
 * @author 崔祥
 * @since 2014-12-18
 */
public class ValidationUtil {

	/**
	 * 正则验证方法
	 * 
	 * @param regexstr
	 * @param str
	 * @return boolean
	 */
	public static boolean match(String regexstr, String str) {
		Pattern regex = Pattern.compile(regexstr, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		Matcher matcher = regex.matcher(str);
		return matcher.matches();
	}

	/**
	 * 邮箱验证
	 * 
	 * @param mail
	 * @return boolean
	 */
	public static boolean isMail(String mail) {
		String mailregex = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		return match(mailregex, mail);
	}

	/**
	 * 验证字母
	 * 
	 * @param alpha
	 * @return boolean
	 */
	public static boolean isAlpha(String alpha) {
		String alpharegex = "^[A-Za-z]+$";
		return match(alpharegex, alpha);
	}

	/**
	 * 验证中文
	 * 
	 * @param zhstr
	 * @return boolean
	 */
	public static boolean isChinese(String zhstr) {
		String chineseregex = "[\u4e00-\u9fa5]{1,}$";
		return match(chineseregex, zhstr);
	}

	/**
	 * 验证数字
	 * 
	 * @param digital
	 * @return boolean
	 */
	public static boolean isDigital(String digital) {
		String digitalregex = "[0-9]*";// ^//d+$";
		return match(digitalregex, digital);
	}

	/**
	 * 手机验证
	 * 
	 * @param mobile
	 * @return boolean
	 */
	public static boolean isMobile(String mobile) {
		String mobileregex = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
		return match(mobileregex, mobile);
	}

	/**
	 * 验证日期
	 * 
	 * @param dateTime
	 * @return boolean
	 */
	public static boolean isDateTime(String dateTime) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(true);
		try {
			dateFormat.parse(dateTime);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	/**
	 * 验证IP
	 * 
	 * @param ip
	 * @return boolean
	 */
	public static boolean isIp(String ip) {
		String ipregex = "^((00//d|1?//d?//d|(2([0-4]//d|5[0-5])))//.){3}(00//d|1?//d?//d|(2([0-4]//d|5[0-5])))$";
		return match(ipregex, ip);
	}

	/**
	 * 电话验证
	 * 
	 * @param Tel
	 * @return boolean
	 */
	public static boolean isTel(String Tel) {
		String telregex = "(^[0-9]{3,4}-[0-9]{7,8}-[0-9]{3,4}$)|(^[0-9]{3,4}-[0-9]{7,8}$)|(^[0-9]{7,8}-[0-9]{3,4}$)|(^[0-9]{7,15}$)";
		return match(telregex, Tel);
	}

	/**
	 * 域名验证
	 * 
	 * @param webdomain
	 * @return boolean
	 */
	public static boolean webdomain(String webdomain) {
		String webdomainregex = "http://([^/]+)/*";
		return match(webdomainregex, webdomain);
	}

	/**
	 * 验证身份证
	 * 
	 * @param idcard
	 * @return boolean
	 */
	public static boolean IdCardNo(String idcard) {
		HashMap<Integer, String> area = new HashMap<Integer, String>();
		area.put(11, "北京");
		area.put(12, "天津");
		area.put(13, "河北");
		area.put(14, "山西");
		area.put(15, "内蒙古");
		area.put(21, "辽宁");
		area.put(22, "吉林");
		area.put(23, "黑龙江");
		area.put(31, "上海");
		area.put(32, "江苏");
		area.put(33, "浙江");
		area.put(34, "安徽");
		area.put(35, "福建");
		area.put(36, "江西");
		area.put(37, "山东");
		area.put(41, "河南");
		area.put(42, "湖北");
		area.put(43, "湖南");
		area.put(44, "广东");
		area.put(45, "广西");
		area.put(46, "海南");
		area.put(50, "重庆");
		area.put(51, "四川");
		area.put(52, "贵州");
		area.put(53, "云南");
		area.put(54, "西藏");
		area.put(61, "陕西");
		area.put(62, "甘肃");
		area.put(63, "青海");
		area.put(64, "宁夏");
		area.put(65, "新疆");
		area.put(71, "台湾");
		area.put(81, "香港");
		area.put(82, "澳门");
		area.put(91, "国外");
		if (StringUtils.isBlank(idcard))
			return false;
		if (area.get(Integer.parseInt(idcard.substring(0, 2))) == null)
			return false;
		if (!(idcard.length() == 15 || idcard.length() == 18))
			return false;
		if (idcard.length() == 15) {
			// 老身份证
			int year = Integer.parseInt(idcard.substring(2, 6)) + 1900;
			String ereg;
			if (year % 4 == 0 || (year % 100 == 0 && year % 4 == 0)) {
				ereg = "^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}$";// 测试出生日期的合法性
			} else {
				ereg = "^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}$";// 测试出生日期的合法性
			}
			if (match(ereg, idcard))
				return true;
			else
				return false;

		} else if (idcard.length() == 18) {
			// 新省份证
			// 18位身份号码检测
			// 出生日期的合法性检查
			// 闰年月日:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))
			// 平年月日:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))
			int year = Integer.parseInt(idcard.substring(2, 6)) + 1900;
			String ereg;
			if (year % 4 == 0 || (year % 100 == 0 && year % 4 == 0)) {
				ereg = "^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9Xx]$";// 闰年出生日期的合法性正则表达式
			} else {
				ereg = "^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9Xx]$";// 平年出生日期的合法性正则表达式
			}
			if (match(ereg, idcard)) {// 测试出生日期的合法性
				// 计算校验位
				int[] idcards = new int[18];
				for (int i = 0; i < idcard.length(); i++) {
					idcards[i] = Integer.parseInt(idcard.substring(i, i + 1));
				}
				int S = (idcards[0] + idcards[10]) * 7 + (idcards[1] + idcards[11]) * 9
						+ (idcards[2] + idcards[12]) * 10 + (idcards[3] + idcards[13]) * 5
						+ (idcards[4] + idcards[14]) * 8 + (idcards[5] + idcards[15]) * 4
						+ (idcards[6] + idcards[16]) * 2 + idcards[7] * 1 + idcards[8] * 6 + idcards[9] * 3;
				int Y = S % 11;
				String M = "F";
				String JYM = "10X98765432";
				M = JYM.substring(Y, Y + 1);// 判断校验位
				if (StringUtils.equalsIgnoreCase(M, String.valueOf(idcards[17])))
					return true; // 检测ID的校验位
				else
					return false;
			} else
				return false;
		}
		return false;
	}

	// public static void main(String[] args) {
	// // 验证中文
	// System.out.println(isChinese("我"));
	// // 验证身份证
	// System.out.println(IdCardNo("341125198808153850"));
	// }

}
