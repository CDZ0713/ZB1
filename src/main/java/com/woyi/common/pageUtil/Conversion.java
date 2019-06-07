/**
 * @单位名称：斡亿信息科技有限公司
 * @Copyright (c) 2016 All Rights Reserved.
 * @系统名称：硒乐网
 * @工程名称：xile-common
 * @文件名称: Conversion.java
 * @类路径: com.woyi.common.pageUtil
 */

package com.woyi.common.pageUtil;

import java.util.regex.Pattern;

/**
 * Page参数的转换 
 * @see		
 * @author  jhuang@woyitech.com
 * @date	2016年2月21日 下午1:45:45
 * @version	 
 * @desc    TODO 转换类
 */
public class Conversion {
	
	/**
	 * pattern 正则匹配--数字
	 */
	private static Pattern pattern = Pattern.compile("\\d*");

	/**
	 * 页码数的参数传递，如果为null则直接转为第一页
	 * 
	 * @param pageNo
	 * @return pageNo
	 */
	public static int nullToFirst(String pageNo) {
		if (pageNo == null) {
			return 1;
		} else {
			return getIntType(pageNo);
		}
	}

	/**
	 * 将字符串转化成int 如果不匹配 则返回-1
	 * 
	 * @param str
	 * @return int
	 */
	public static int getIntType(String str) {
		if (str.length() == 0) {
			return 1;
		}
		boolean bl = pattern.matcher(str).matches();
		if (bl) {
			return Integer.parseInt(str);
		}
		return 1;
	}
}

