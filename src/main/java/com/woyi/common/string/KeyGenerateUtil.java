package com.woyi.common.string;

import java.util.Random;

public class KeyGenerateUtil {

	private static char[] letter = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	/**
	 * 生成指定位数的随机数字
	 * @param number
	 * @return
	 */
	public static String generateNumber(int number) {

		char[] code = new char[number];
		int randomValue;
		Random random = new Random();

		for (int i = 0; i < number; i++) {
			randomValue = random.nextInt(letter.length);
			code[i] = letter[randomValue];
		}
		return String.valueOf(code);
	}
	

	
	public static void main(String[] args){
		System.out.println(generateNumber(6));
	}
}
// user_appkey为用户id，api_id,8位的36位随即数md5生成。
// user_secret为用户id，时间戳，api_id,8位的36位随机数加secret再md5生成

// var user_appkey = createmd5(userid+api_id+util.random36(8));
// var user_secret = createmd5(userid+timestamp+api_id+util.random36(8)+secret);

