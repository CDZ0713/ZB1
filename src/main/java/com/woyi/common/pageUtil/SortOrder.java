package com.woyi.common.pageUtil;

import org.apache.commons.lang.StringUtils;

import java.io.Serializable;

/**
 * 排序
 * @ClassName  SortOrder 
 * @Description  TODO
 * @author  jfli@woyitech.com
 * @date  2016年5月27日 下午5:20:21
 */
public class SortOrder implements Serializable {
	private static final long serialVersionUID = 3418678302342846957L;
	/**
	 * 排序属性名 
	 */
	private String orderProperty;// 排序属性名 采用驼峰格式，服务端自动与数据库转换
	/**
	 * 排序规则 asc desc
	 */
	private String orderRule;// 排序规则 asc desc

	/**
	 * 构造器
	 * @Title SortOrder
	 * @Description TODO
	 */
	public SortOrder() {
		super();
	}
	/**
	 * 构造器
	 * @Title SortOrder
	 * @Description TODO 
	 * @param orderProperty
	 * @param orderRule
	 */
	public SortOrder(String orderProperty, String orderRule) {
		super();
		this.orderProperty = orderProperty;
		this.orderRule = orderRule;
	}
	/**
	 * getOrderProperty
	 * @Title  getOrderProperty 
	 * @Description  TODO
	 * @author  jfli@woyitech.com
	 * @return
	 * @return  String
	 */
	public String getOrderProperty() {
		return orderProperty;
	}
	/**
	 * setOrderProperty
	 * @Title  setOrderProperty 
	 * @Description  TODO
	 * @author  jfli@woyitech.com
	 * @param orderProperty
	 * @return 
	 */
	public void setOrderProperty(String orderProperty) {
		this.orderProperty = orderProperty;
	}
	/**
	 * getOrderRule
	 * @Title  getOrderRule 
	 * @Description  TODO
	 * @author  jfli@woyitech.com
	 * @return
	 * @return  String
	 */
	public String getOrderRule() {
		return orderRule;
	}
	/**
	 * setOrderRule
	 * @Title  setOrderRule 
	 * @Description  TODO
	 * @author  jfli@woyitech.com
	 * @param orderBy
	 * @return
	 */
	public void setOrderRule(OrderByEnum orderBy) {
		this.orderRule = orderBy.getMsg();
	}
	/**
	 * toString 方法重写
	 * @Title toString
	 * @Description TODO
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String resultStr = "";
		if (StringUtils.isNotEmpty(orderProperty)) {
			resultStr += orderProperty + " ";// 排序字段
			if (StringUtils.isNotEmpty(orderRule)) {
				resultStr += orderRule + " ";// 排序规则
			}
		}
		return resultStr;
	}
}
