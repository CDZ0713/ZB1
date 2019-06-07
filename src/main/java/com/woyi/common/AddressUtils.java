package com.woyi.common;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 根据IP地址获取详细的地域信息
 * 
 * @author Gongzhongyi
 * @since 2014-12-22
 */
public class AddressUtils {

	/**
	 * 
	 * 得到省份名，或者直辖市，自治区
	 * 
	 * @param content
	 *            请求的参数 格式为：name=xxx&pwd=xxx
	 * @param encodingString
	 *            服务器端请求编码。如GBK,UTF-8等
	 * @return String
	 * @throws UnsupportedEncodingException
	 */
	public static String getAddresses(String content, String encodingString) throws UnsupportedEncodingException {
		String urlStr = "http://ip.taobao.com/service/getIpInfo.php";
		String returnStr = getResult(urlStr, content, encodingString);
		// System.out.println(returnStr);//结果就是下面的一句话
		/*
		 * //几乎所有的信息都在哦
		 * {"code":0,"data":{"country":"\u4e2d\u56fd","country_id":"CN","area":
		 * "\u534e\u5357","area_id":"800000","region":"\u5e7f\u4e1c\u7701",
		 * "region_id":"440000","city":"\u5e7f\u5dde\u5e02","city_id":"440100",
		 * "county":"\u8d8a\u79c0\u533a","county_id":"440104","isp":
		 * "\u7535\u4fe1","isp_id":"100017","ip":"219.136.134.157"}}
		 */
		if (returnStr != null) {
			// 处理返回的省市区信息
			String[] temp = returnStr.split(",");
			if (temp.length < 3) {
				return "0";// 无效IP，局域网测试
			}
			String region = (temp[5].split(":"))[1].replaceAll("\"", "");
			region = decodeUnicode(region);// 省份
			// System.out.println(region);

			/*
			 * String region1 = (temp[7].split(":"))[1].replaceAll("\"", "");
			 * region1 = decodeUnicode(region1);// 市份
			 * System.out.println(region1);
			 */
			return region;
		}
		return null;
	}

	/**
	 * 得到某个ip地址几乎所有的有用信息
	 * 
	 * @param urlStr
	 *            请求的地址
	 * @param content
	 *            请求的参数 格式为：name=xxx&pwd=xxx
	 * @param encoding
	 *            服务器端请求编码。如GBK,UTF-8等
	 * @return String
	 */
	private static String getResult(String urlStr, String content, String encoding) {
		URL url = null;
		HttpURLConnection connection = null;
		try {
			url = new URL(urlStr);
			connection = (HttpURLConnection) url.openConnection();// 新建连接实例
			connection.setConnectTimeout(2000);// 设置连接超时时间，单位毫秒
			connection.setReadTimeout(2000);// 设置读取数据超时时间，单位毫秒
			connection.setDoOutput(true);// 是否打开输出流 true|false
			connection.setDoInput(true);// 是否打开输入流true|false
			connection.setRequestMethod("POST");// 提交方法POST|GET
			connection.setUseCaches(false);// 是否缓存true|false
			connection.connect();// 打开连接端口
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());// 打开输出流往对端服务器写数据
			out.writeBytes(content);// 写数据,也就是提交你的表单 name=xxx&pwd=xxx
			out.flush();// 刷新
			out.close();// 关闭输出流
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), encoding));// 往对端写完数据对端服务器返回数据
																														// ,以BufferedReader流来读取
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			reader.close();
			return buffer.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.disconnect();// 关闭连接
			}
		}
		return null;
	}

	/**
	 * Unicode 转换成 中文
	 * 
	 * @param theString
	 * @return 中文信息
	 */
	public static String decodeUnicode(String theString) {
		char aChar;
		int len = theString.length();
		StringBuffer outBuffer = new StringBuffer(len);
		for (int x = 0; x < len;) {
			aChar = theString.charAt(x++);
			if (aChar == '\\') {
				aChar = theString.charAt(x++);
				if (aChar == 'u') {
					int value = 0;
					for (int i = 0; i < 4; i++) {
						aChar = theString.charAt(x++);
						switch (aChar) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							value = (value << 4) + aChar - '0';
							break;
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
							value = (value << 4) + 10 + aChar - 'a';
							break;
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
							value = (value << 4) + 10 + aChar - 'A';
							break;
						default:
							throw new IllegalArgumentException("Malformed      encoding.");
						}
					}
					outBuffer.append((char) value);
				} else {
					if (aChar == 't') {
						aChar = '\t';
					} else if (aChar == 'r') {
						aChar = '\r';
					} else if (aChar == 'n') {
						aChar = '\n';
					} else if (aChar == 'f') {
						aChar = '\f';
					}
					outBuffer.append(aChar);
				}
			} else {
				outBuffer.append(aChar);
			}
		}
		return outBuffer.toString();
	}

	/*
	 * 
	 * // public static void main(String[] args) { // //ip---> 219.136.134.157
	 * --->广东省 // String ip = "219.136.134.157"; // String address = ""; // try
	 * { // address = AddressUtils.getAddresses("ip="+ip, "utf-8"); // //
	 * if(address!=null && address.length() >= 2){ // if(address.indexOf("内蒙古")
	 * != -1 || address.indexOf("黑龙江")!=-1){ // address =
	 * address.substring(0,3); // }else if(address.indexOf("香港") != -1 ||
	 * address.indexOf("澳门") !=-1 || address.indexOf("台湾") !=-1){ // address =
	 * "港澳台"; // }else{ // address = address.substring(0,2); // } // } // }
	 * catch (UnsupportedEncodingException e) { // e.printStackTrace(); // } //
	 * System.out.println(address); // }
	 */
}
