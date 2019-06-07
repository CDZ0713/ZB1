package com.woyi.common.cryptology;

/**
 * 16禁止字节组与字符串的工具类 
 * @ClassName  HexUtils 
 * @Description  TODO
 * @author  jfli@woyitech.com
 * @date  2016年5月27日 下午12:47:56
 */
public class HexUtils {
	/**
	 * toHex
	 * @Title  toHex 
	 * @Description  TODO
	 * @author  jfli@woyitech.com
	 * @param digestByte
	 * @return
	 * @return  byte[]
	 */
	public static byte[] toHex(byte[] digestByte) {
		byte[] rtChar = new byte[digestByte.length * 2];
		for (int i = 0; i < digestByte.length; i++) {
			byte b1 = (byte) (digestByte[i] >> 4 & 0x0f);
			byte b2 = (byte) (digestByte[i] & 0x0f);
			rtChar[i * 2] = (byte) (b1 < 10 ? b1 + 48 : b1 + 55);
			rtChar[i * 2 + 1] = (byte) (b2 < 10 ? b2 + 48 : b2 + 55);
		}
		return rtChar;
	}
	
	/**
	 * toHexString
	 * @Title  toHexString 
	 * @Description  TODO
	 * @author  jfli@woyitech.com
	 * @param digestByte
	 * @return
	 * @return  String
	 */
	public static String toHexString(byte[] digestByte) {
		return new String(toHex(digestByte));
	}
	
	/**
	 * fromHex
	 * @Title  fromHex 
	 * @Description  TODO
	 * @author  jfli@woyitech.com
	 * @param sc
	 * @return
	 * @return  byte[]
	 */
	public static byte[] fromHex(byte[] sc) {
		byte[] res = new byte[sc.length / 2];
		for (int i = 0; i < sc.length; i++) {
			byte c1 = (byte) (sc[i] - 48 < 17 ? sc[i] - 48 : sc[i] - 55);
			i++;
			byte c2 = (byte) (sc[i] - 48 < 17 ? sc[i] - 48 : sc[i] - 55);
			res[i / 2] = (byte) (c1 * 16 + c2);
		}
		return res;
	}
	
	/**
	 * fromHexString
	 * @Title  fromHexString 
	 * @Description  TODO
	 * @author  jfli@woyitech.com
	 * @param hex
	 * @return
	 * @return  byte[]
	 */
	public static byte[] fromHexString(String hex) {
		return fromHex(hex.getBytes());
	}
	
	/**
	 * encode
	 * @Title  encode 
	 * @Description  TODO
	 * @author  jfli@woyitech.com
	 * @param in
	 * @return
	 * @return  String
	 */
	public static String encode(String in) {
		return new String(toHex(in.getBytes()));
	}
	/**
	 * decode
	 * @Title  decode 
	 * @Description  TODO
	 * @author  jfli@woyitech.com
	 * @param in
	 * @return
	 * @return  String
	 */
	public static String decode(String in) {
		return new String(fromHex(in.getBytes()));
	}
}
