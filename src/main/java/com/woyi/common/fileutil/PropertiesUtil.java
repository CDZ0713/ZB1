package com.woyi.common.fileutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 文件处理工具类
 * 
 * @author 崔祥
 * @since 2014-12-18
 */
public class PropertiesUtil {

	/**
	 * 从.properties文件中的得到key的值
	 * 
	 * @param fileUrl
	 * @param key
	 * @return String
	 */
	public static String getPropreties(String fileUrl, String key) {
		Properties props = new Properties();
		File f = new File(fileUrl);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
			props.load(fis);
			fis.close();
			return (String) props.get(key);
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 通过properties 得到map
	 * 
	 * @param p
	 * @return String
	 */
	public static Map<String, String> getMap(Properties p) {
		Map<String, String> map = new HashMap<String, String>();
		Set<Object> set = p.keySet();
		for (Object o : set) {
			String tempKey = o.toString();
			map.put(tempKey, p.getProperty(tempKey));
		}
		return map;
	}

	/**
	 * 从.properite文件中的得到properites的map值
	 * 
	 * @param fileUrl
	 * @return Map<String, String>
	 */
	public static Map<String, String> getPropreties(String fileUrl) {
		Properties props = new Properties();
		File f = new File(fileUrl);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
			props.load(fis);
			fis.close();
			return getMap(props);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 向文件中写数据 如果有key则修改key的值没有则添加key的值
	 * @param fileUrl
	 * @param key
	 * @param value
	 */
	public static void putProperties(String fileUrl, String key, String value) {
		Properties props = new Properties();
		File f = new File(fileUrl);
		InputStream fis = null;
		try {
			fis = new FileInputStream(fileUrl);
			props.load(fis);
			for (String s : props.stringPropertyNames()) {
				if (!s.equals(key)) {
					props.setProperty(key, value + "");
				} else {
					props.setProperty(s, props.getProperty(s) + "");
				}
			}
			fis.close();
			FileOutputStream fos = new FileOutputStream(f);
			props.store(fos, "update");
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
