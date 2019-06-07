/**
 * @单位名称：和泰通汇—跨境电子商务云平台
 * @Copyright (c) 2014 All Rights Reserved.
 * @系统名称：HTTH-CLOUD
 * @工程名称：htth.cloud.portal
 * @文件名称: SmsSender.java
 * @类路径: com.htth.silomall.aui.htth.support
 */

package com.woyi.common.sms;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 
 * @see
 * @author peichuang@silomall.com
 * @date 2014-8-13 下午4:40:46
 * @version
 * @desc 短信平台接口
 */
public class SmsSender {

	private static final Logger logger = Logger.getLogger(SmsSender.class);
	//短信配置
	public String sms_addr = "sms_addr";
	public String sms_userId = "sms_userId";
	public String sms_pwd = "sms_pwd";
	public String sms_encode = "utf8";
	/*
	 * 如uid是：test，登录密码是：123123 pwd=md5(123123test),即
	 * pwd=b9887c5ebb23ebb294acab183ecf0769
	 * 
	 * 线生成地址：http://www.sms.cn/password
	 */
	public String send(String mobile,String msgContent) throws Exception {

		// 组建请求
		String straddr = sms_addr + "?uid="
				+ sms_userId + "&pwd=" + sms_pwd
				+ "&mobile=" + mobile + "&encode=" + sms_encode
				+ "&content=" + msgContent;
		StringBuffer sb = new StringBuffer(straddr);
		System.out.println(sb.toString());
		logger.info(sb.toString());

		// 发送请求
		URL url = new URL(sb.toString());
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		BufferedReader in = new BufferedReader(new InputStreamReader(
				url.openStream(),"GBK"));
		
		// 返回结果
		String inputline = "";
		String readline = in.readLine();
		while(readline != null && !readline.equals("")){
			inputline +=readline + "\n";
			readline = in.readLine();
		}
		System.out.println("Response:" + inputline);
		logger.info(inputline);
		return inputline;
	}
//	public static void  main(String[] args) throws Exception{
//		send("18939269786","test");
//	}
	public String getSms_addr() {
		return sms_addr;
	}
	public void setSms_addr(String sms_addr) {
		this.sms_addr = sms_addr;
	}
	public String getSms_userId() {
		return sms_userId;
	}
	public void setSms_userId(String sms_userId) {
		this.sms_userId = sms_userId;
	}
	public String getSms_pwd() {
		return sms_pwd;
	}
	public void setSms_pwd(String sms_pwd) {
		this.sms_pwd = sms_pwd;
	}
	public String getSms_encode() {
		return sms_encode;
	}
	public void setSms_encode(String sms_encode) {
		this.sms_encode = sms_encode;
	}
	
}
