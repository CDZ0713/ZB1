package com.woyi.common.cryptology;

import java.security.MessageDigest;

/**
 * MD5加密工具
 * @author 崔祥
 * @since 2014-12-18
 */
public class Md5Util {
	
/**
 * 默认构造器
 * @Title Md5Util
 * @Description TODO
 */
  public Md5Util() {

  }
  
  /**
   * HEX_DIGITS
   */
  private static final String[] HEX_DIGITS = {
      "0", "1", "2", "3", "4", "5", "6", "7",
      "8", "9", "a", "b", "c", "d", "e", "f"};

  /**
   * 转换字节数组为16进制字串
   * @param b 字节数组
   * @return 16进制字串
   */
  public static String byteArrayToString(byte[] b) {
    StringBuffer resultSb = new StringBuffer();
    for (int i = 0; i < b.length; i++) {
      resultSb.append(byteToHexString(b[i]));
      //若使用本函数转换则可得到加密结果的16进制表示，即数字字母混合的形式
//      resultSb.append(byteToNumString(b[i]));//使用本函数则返回加密结果的10进制数字字串，即全数字形式
    }
    return resultSb.toString();
  }
  
  /**
   * 转换字节数组为16进制字串
   * @Title  byteToHexString 
   * @Description  TODO
   * @author  jfli@woyitech.com
   * @param b
   * @return
   * @return  String
   */
  private static String byteToHexString(byte b) {
    int n = b;
    if (n < 0) {
      n = 256 + n;
    }
    int d1 = n / 16;
    int d2 = n % 16;
    return HEX_DIGITS[d1] + HEX_DIGITS[d2];
  }

  /**
   * 对传入字符串进行md5加密
   * @param origin
   * @return 返回加密字符串
   */
  public static String md5Encode(String origin) {
    String resultString = null;

    try {
      resultString = new String(origin);
      MessageDigest md = MessageDigest.getInstance("MD5");
      resultString = byteArrayToString(md.digest(resultString.getBytes()));
    } catch (Exception ex) {
    	ex.printStackTrace();
    }
    return resultString;
  }

  public static void main(String[] args) {
    String API_KEY = "581af98d70ae2b85c4ecb9c784";
    long ticks = System.currentTimeMillis()/1000;

    String str = Md5Util.md5Encode("o4YVywihP24BSMSKKnxTFGacF3HU" + "1513847435" + API_KEY);
    System.out.println(str);
  }
  
}

