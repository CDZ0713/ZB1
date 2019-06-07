package com.woyi.common.fileutil;

/**
 * 文件上传状态
 * @since 2010-10-11 下午12:18:14
 * @author 崔祥
 */
public enum UploadState {
	/**
	 * 上传文件成功！
	 */
	UPLOAD_SUCCSSS(0, "上传文件成功！"), 
	/**
	 * 上传文件失败！
	 */
	UPLOAD_FAILURE(1, "上传文件失败！"), 
	/**
	 * 上传文件类型错误！
	 */
	UPLOAD_TYPE_ERROR(2, "上传文件类型错误！"),
	/**
	 * 上传文件过大！
	 */
	UPLOAD_OVERSIZE(3, "上传文件过大！"), 
	/**
	 * 上传文件为空！
	 */
	UPLOAD_ZEROSIZE(4, "上传文件为空！"), 
	/**
	 * 上传文件路径错误！
	 */
	UPLOAD_NOTFOUND(5, "上传文件路径错误！");
	/**
	 * 状态
	 */
	private String state;
	/**
	 * 标志
	 */
	private int flag;
	
	/**
	 * getState
	 * @Title  getState 
	 * @Description  TODO
	 * @author  jfli@woyitech.com
	 * @return
	 * @return  String
	 */
	public String getState() {
		return this.state;
	}
	/**
	 * getFlag
	 * @Title  getFlag 
	 * @Description  TODO
	 * @author  jfli@woyitech.com
	 * @return
	 * @return  int
	 */
	public int getFlag() {
		return this.flag;
	}
	/**
	 * 构造器
	 * @Title UploadState
	 * @Description TODO 
	 * @param flag
	 * @param state
	 */
	UploadState(int flag, String state) {
		this.state = state;
		this.flag = flag;
	}
}
