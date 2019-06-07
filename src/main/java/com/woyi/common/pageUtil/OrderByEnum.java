package com.woyi.common.pageUtil;

/**
 * 升序和降序枚举
 * @ClassName OrderByEnum
 * @Description TODO
 * @author jfli@woyitech.com
 * @date 2016年5月27日 下午1:26:35
 */
public enum OrderByEnum {
	
	/**
	 * DESC
	 */
	DESC(2, "desc"), 
	/**
	 * ASC
	 */
	ASC(1, "asc");
	/**
	 * index
	 */
	private int index;
	/**
	 * msg
	 */
	private String msg;
	
	/**
	 * 构造器
	 * @Title OrderByEnum
	 * @Description TODO 
	 * @param index
	 * @param msg
	 */
	OrderByEnum(int index, String msg) {
		this.index = index;
		this.msg = msg;
	}
	/**
	 * getIndex
	 * @Title  getIndex 
	 * @Description  TODO
	 * @author  jfli@woyitech.com
	 * @return
	 * @return  int
	 */
	public int getIndex() {
		return index;
	}
	/**
	 * getMsg
	 * @Title  getMsg 
	 * @Description  TODO
	 * @author  jfli@woyitech.com
	 * @return
	 * @return  String
	 */
	public String getMsg() {
		return msg;
	}
	
	
	/**
	 * 根据index获取升序，降序的字符串
	 * @Title  get 
	 * @Description  TODO
	 * @author  jfli@woyitech.com
	 * @param index
	 * @return
	 * @return  String
	 */
	public static String get(int index){
		OrderByEnum[] values = OrderByEnum.values();
		for(OrderByEnum value:values){
			if(value.getIndex() == index){
				return value.getMsg();
			}
		}
		//默认升序
		return ASC.getMsg();
	}
	
}
