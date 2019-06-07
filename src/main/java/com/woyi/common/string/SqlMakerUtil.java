/**
 * @单位名称：斡亿信息科技有限公司
 * @Copyright (c) 2016 All Rights Reserved.
 * @系统名称：硒乐网
 * @工程名称：xile-common
 * @文件名称: SqlMakerUtil.java
 * @类路径: com.woyi.common.string
 */

package com.woyi.common.string;

import org.apache.commons.lang.StringUtils;

/**
 *
 * @see		
 * @author  jhuang@woyitech.com
 * @date	2016年2月21日 下午1:06:58
 * @version	 
 * @desc    TODO
 */
public class SqlMakerUtil {
	
	private SqlMakerUtil() {

	}
	
	/**
	 * 防止sql注入
	 * 
	 * @param str
	 * @return
	 */
	private static String filterSql(String str) {
		if (str != null && !"".equals(str)) {
			str = str.replace("'", "''");
		}
		return str;
	}
	
	/**
	 * 
			* 此方法描述的是：组装IN SQL
			* @author: philwilla@sina.com
			* @version: Jan 28, 2011
			1:56:34 PM
	 */
	public static String popuInSql(String tableAlias, String cloumnName,
			String cloumnValue) {
		if (StringUtils.isNotBlank(cloumnValue)) {
			StringBuffer sb = new StringBuffer();
			sb.append(" and ").append(tableAlias).append(".")
					.append(cloumnName).append(" in (").append(
							filterSql(cloumnValue)).append(")");
			return sb.toString();
		}
		return "";
	}

	/**
	 * 组装like sql
	 * 
	 * @param tableAlias
	 *            表的别名
	 * @param cloumnName
	 *            需要查询的字段名称
	 * @param cloumnValue
	 *            需要查询的字段的值
	 * @return
	 */
	public static String popuLikeSql(String tableAlias, String cloumnName,
			String cloumnValue) {
		if (StringUtils.isNotBlank(cloumnValue)) {
			StringBuffer sb = new StringBuffer();
			sb.append(" and ").append(tableAlias).append(".")
					.append(cloumnName).append(" like '%").append(
							filterSql(cloumnValue)).append("%'");
			return sb.toString();
		}
		return "";
	}

	/**
	 * 组装contain sql
	 * 
	 * @param tableAlias
	 * @param cloumnName
	 * @param cloumnValue
	 * @return
	 */
	public static String popuContainSql(String tableAlias, String cloumnName,
			String cloumnValue) {
		if (StringUtils.isNotBlank(cloumnValue)) {
			StringBuffer sb = new StringBuffer();
			sb.append(" and ").append(" contains(").append(tableAlias).append(
					".").append(cloumnName).append(",'").append(
					filterSql(cloumnValue)).append("') > 0");
			return sb.toString();
		}
		return "";
	}

	/**
	 * 组装eq sql
	 * 
	 * @param tableAlias
	 *            表的别名
	 * @param cloumnName
	 *            需要查询的字段名称
	 * @param cloumnValue
	 *            需要查询的字段的值 字符串
	 * @return
	 */
	public static String popuEqSql(String tableAlias, String cloumnName,
			String cloumnValue) {
		if (StringUtils.isNotBlank(cloumnValue)) {
			StringBuffer sb = new StringBuffer();
			sb.append(" and ").append(tableAlias).append(".")
					.append(cloumnName).append("='").append(
							filterSql(cloumnValue)).append("'");
			return sb.toString();
		}
		return "";
	}

	/**
	 * 
	 * 此方法描述的是：not eq
	 * 
	 * @author: philwilla@sina.com
	 * @version: Jan 7, 2011 6:31:12 PM
	 */
	public static String popuNotEqSql(String tableAlias, String cloumnName,
			String cloumnValue) {
		if (StringUtils.isNotBlank(cloumnValue)) {
			StringBuffer sb = new StringBuffer();
			sb.append(" and ").append(tableAlias).append(".")
					.append(cloumnName).append("!='").append(
							filterSql(cloumnValue)).append("'");
			return sb.toString();
		}
		return "";
	}

	/**
	 * 组装eq sql
	 * 
	 * @param tableAlias
	 *            表的别名
	 * @param cloumnName
	 *            需要查询的字段名称
	 * @param cloumnValue
	 *            需要查询的字段的值 整型
	 * @return
	 */
	public static String popuEqSql(String tableAlias, String cloumnName,
			Integer cloumnValue) {
		if (cloumnValue != null) {
			StringBuffer sb = new StringBuffer();
			sb.append(" and ").append(tableAlias).append(".")
					.append(cloumnName).append("=").append(cloumnValue);
			return sb.toString();
		}
		return "";
	}

	/**
	 * 组装eq sql
	 * 
	 * @param tableAlias
	 *            表的别名
	 * @param cloumnName
	 *            需要查询的字段名称
	 * @param cloumnValue
	 *            需要查询的字段的值 长整型
	 * @return
	 */
	public static String popuEqSql(String tableAlias, String cloumnName,
			Long cloumnValue) {
		if (cloumnValue != null) {
			StringBuffer sb = new StringBuffer();
			sb.append(" and ").append(tableAlias).append(".")
					.append(cloumnName).append("=").append(cloumnValue);
			return sb.toString();
		}
		return "";
	}

	/**
	 * 组装eq sql
	 * 
	 * @param cloumnName
	 *            需要查询的字段名称
	 * @param cloumnValue
	 *            需要查询的字段的值 字符串
	 * @return
	 */
	public static String popuEqSql(String cloumnName, String cloumnValue) {
		if (StringUtils.isNotBlank(cloumnValue)) {
			StringBuffer sb = new StringBuffer();
			sb.append(" and ").append(cloumnName).append("='").append(
					filterSql(cloumnValue)).append("'");
			return sb.toString();
		}
		return "";

	}

	/**
	 * 组装eq sql
	 * 
	 * @param tableAlias
	 *            表的别名
	 * @param cloumnName
	 *            需要查询的字段名称
	 * @param cloumnValue
	 *            需要查询的字段的值 整型 长整型
	 * @return
	 */
	public static String popuEqSql(String cloumnName, Integer cloumnValue) {
		if (cloumnValue != null) {
			StringBuffer sb = new StringBuffer();
			sb.append(" and ").append(cloumnName).append("=").append(
					cloumnValue);
			return sb.toString();
		}
		return "";
	}

	/**
	 * 组装eq sql
	 * 
	 * @param tableAlias
	 *            表的别名
	 * @param cloumnName
	 *            需要查询的字段名称
	 * @param cloumnValue
	 *            需要查询的字段的值 整型 长整型
	 * @return
	 */
	public static String popuEqSql(String cloumnName, Long cloumnValue) {
		if (cloumnValue != null) {
			StringBuffer sb = new StringBuffer();
			sb.append(" and ").append(cloumnName).append("=").append(
					cloumnValue);
			return sb.toString();
		}
		return "";
	}

	public static String popuInSql(String cloumnName, Long cloumnValue) {
		if (cloumnValue != null) {
			StringBuffer sb = new StringBuffer();
			sb.append(" and ").append(cloumnName).append(" in (").append(
					cloumnValue).append(" ");
			return sb.toString();
		}
		return "";
	}
	
	/** *******oracle数据库 时间比较的方法********* */
	/**
	 * 组装orale date sql
	 * 
	 * @param tableAlias
	 *            表的别名
	 * @param cloumnName
	 *            需要查询的字段名称 数据库字段为日期类型
	 * @param cloumnValue
	 *            需要查询的字段的值 字符串 yyyy-mm-dd
	 * @return
	 */
	public static String popuBeginDateOra(String tableAlias, String cloumnName,
			String cloumnValue) {
		if (StringUtils.isNotBlank(cloumnValue)) {
			StringBuffer sb = new StringBuffer();
			sb.append(" and to_date(' ").append(filterSql(cloumnValue)).append(
					"  00:00:00', 'yyyy-mm-dd HH24:MI:SS') <= ").append(
					tableAlias).append(".").append(cloumnName);
			return sb.toString();
		}
		return "";

	}

	/**
	 * 组装orale date sql
	 * 
	 * @param cloumnName
	 *            需要查询的字段名称 数据库字段为日期类型
	 * @param cloumnValue
	 *            需要查询的字段的值 字符串 yyyy-mm-dd
	 * @return
	 */
	public static String popuBeginDateOra(String cloumnName, String cloumnValue) {
		if (StringUtils.isNotBlank(cloumnValue)) {
			StringBuffer sb = new StringBuffer();
			sb.append(" and to_date(' ").append(filterSql(cloumnValue)).append(
					"  00:00:00', 'yyyy-mm-dd HH24:MI:SS') <= ").append(".")
					.append(cloumnName);
			return sb.toString();
		}
		return "";
	}

	/**
	 * 组装orale date sql
	 * 
	 * @param tableAlias
	 *            表的别名
	 * @param cloumnName
	 *            需要查询的字段名称 数据库字段为日期类型
	 * @param cloumnValue
	 *            需要查询的字段的值 字符串 yyyy-mm-dd
	 * @return
	 */
	public static String popuEndDateOra(String tableAlias, String cloumnName,
			String cloumnValue) {
		if (StringUtils.isNotBlank(cloumnValue)) {
			StringBuffer sb = new StringBuffer();
			sb.append(" and to_date(' ").append(filterSql(cloumnValue)).append(
					"  23:59:59', 'yyyy-mm-dd HH24:MI:SS') >= ").append(
					tableAlias).append(".").append(cloumnName);
			return sb.toString();
		}
		return "";
	}

	/**
	 * 组装orale date sql
	 * 
	 * @param cloumnName
	 *            需要查询的字段名称 数据库字段为日期类型
	 * @param cloumnValue
	 *            需要查询的字段的值 字符串 yyyy-mm-dd
	 * @return
	 */
	public static String popuEndDateOra(String cloumnName, String cloumnValue) {
		if (StringUtils.isNotBlank(cloumnValue)) {
			StringBuffer sb = new StringBuffer();
			sb.append(" and to_date(' ").append(filterSql(cloumnValue)).append(
					"  23:59:59', 'yyyy-mm-dd HH24:MI:SS') >= ").append(".")
					.append(cloumnName);
			return sb.toString();
		}
		return "";
	}

	/** *******oracle数据库 时间比较的方法********* */

}

