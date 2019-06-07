package com.woyi.common.pageUtil;

import net.sf.json.JSONObject;

import java.sql.Timestamp;
import java.util.LinkedHashMap;

/**
 * MapBean 
 * @ClassName  MapBean 
 * @Description  TODO
 * @author  jfli@woyitech.com
 * @date  2016年5月27日 下午1:20:05
 */
@SuppressWarnings("serial")
public class MapBean extends LinkedHashMap<String, Object> {
	/**
	 * 默认构造器
	 * @Title MapBean
	 * @Description TODO
	 */
	public MapBean() {
	}
	/**
	 * 构造器
	 * @Title MapBean
	 * @Description TODO 
	 * @param args
	 */
	public MapBean(Object... args) {
		put(args);
	}
	/**
	 * 获取int型对象
	 * @Title  getInt 
	 * @Description  TODO
	 * @author  jfli@woyitech.com
	 * @param key
	 * @return
	 * @return  int
	 */
	public int getInt(Object key) {
		return getInt(key, 0);
	}
	/**
	 * getInt
	 * @Title  getInt 
	 * @Description  TODO
	 * @author  jfli@woyitech.com
	 * @param key
	 * @param defaultInt
	 * @return
	 * @return  int
	 */
	public int getInt(Object key, int defaultInt) {
		Integer i = (Integer) get(key);
		return i == null ? defaultInt : i;
	}
	/**
	 * 获取String型对象
	 * @Title  getString 
	 * @Description  TODO
	 * @author  jfli@woyitech.com
	 * @param key
	 * @return
	 * @return  String
	 */
	public String getString(Object key) {
		return (String) get(key);
	}
	/**
	 * 获取String型对象
	 * @Title  getString 
	 * @Description  TODO
	 * @author  jfli@woyitech.com
	 * @param key
	 * @param defaultValue
	 * @return
	 * @return  String
	 */
	public String getString(Object key, String defaultValue) {
		String value = (String) get(key);
		return value == null ? defaultValue : value;
	}
	/**
	 * 获取Timestamp对象
	 * @Title  getTimestamp 
	 * @Description  TODO
	 * @author  jfli@woyitech.com
	 * @param key
	 * @return
	 * @return  Timestamp
	 */
	public Timestamp getTimestamp(Object key) {
		return (Timestamp) get(key);
	}
	/**
	 * put 对象及key(对象的toString)
	 * @Title  put 
	 * @Description  TODO
	 * @author  jfli@woyitech.com
	 * @param args
	 * @return
	 */
	public void put(Object... args) {
		for (int i = 1; i < args.length; i += 2) {
			put(String.valueOf(args[i - 1]), args[i]);
		}
	}
	/**
	 * 转换成json
	 * @Title  toJson 
	 * @Description  TODO
	 * @author  jfli@woyitech.com
	 * @return
	 * @return  JSONObject
	 */
	public JSONObject toJson() {
		return JSONObject.fromObject(this);
	}
	
	/**
	 * 转换成json
	 * @Title  toJson 
	 * @Description  TODO
	 * @author  jfli@woyitech.com
	 * @param keys
	 * @return
	 * @return  JSONObject
	 */
	public JSONObject toJson(String... keys) {
		return JSONObject.fromObject(keys);
	}
	
	/**
	 * 获取json类型的字符串
	 * @Title  toJsonString 
	 * @Description  TODO
	 * @author  jfli@woyitech.com
	 * @return
	 * @return  String
	 */
	public String toJsonString() {
		return toJson().toString();
	}
}
