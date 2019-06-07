package com.woyi.common.properties;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigConstant {
	private static Logger log = Logger.getLogger(ConfigConstant.class);	
	// 发信人邮箱
		public static String from_mail_address = "abc@test.com";
		public static String from_mail_password = "123456";

		// 邮箱服务器
		public static String smtp_server = "smtp.ym.163.com";
		
		public static String internet_address = "test";

		//短信配置
		public static String sms_addr = "sms_addr";
		public static String sms_userId = "sms_userId";
		public static String sms_pwd = "sms_pwd";
		public static String sms_encode = "sms_encode";
		
		static{
			Properties prop = new Properties();   
	        InputStream in = Object.class.getClassLoader().getResourceAsStream("config.properties");   
	        try {
	            prop.load(in);   
	            from_mail_address = prop.getProperty("from_mail_address");   
	            from_mail_password = prop.getProperty("from_mail_password");   
	            smtp_server = prop.getProperty("smtp_server");  
	            internet_address = prop.getProperty("internet_address");  
	            
	            sms_addr = prop.getProperty("sms.addr");   
	            sms_userId = prop.getProperty("sms.userId");   
	            sms_pwd = prop.getProperty("sms.pwd");  
	            sms_encode = prop.getProperty("sms.encode");  
	        } catch (IOException e) {   
	            e.printStackTrace(); 
	            log.error(e.getMessage());
	        }   
		}
}
