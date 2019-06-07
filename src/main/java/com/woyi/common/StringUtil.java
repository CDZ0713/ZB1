package com.woyi.common;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * String工具类
 */
public class StringUtil {
	/***
	 * 将列表转换为字符串输出
	 * 
	 * @param arr
	 * @param split
	 */
	@SuppressWarnings("rawtypes")
	public static String getStrByArray(ArrayList arr, String split) {
		String outstr = "";
		for (int i = 0; i < arr.size(); i++) {
			outstr += arr.get(i) + split;
		}
		if (outstr.length() > 0) {
			outstr = outstr.substring(0, outstr.length() - 1);
		}
		return outstr;
	}

	/**
	 * 将GBK字符转化为ISO字符
	 * 
	 * @param str
	 */
	public static String getISOFromGBK(String str) {
		try {
			if (str == null)
				str = "";
			byte[] buf = str.getBytes("gbk");
			byte[] buf2 = str.getBytes("iso-8859-1");
			if (!str.equals(new String(buf2, "iso-8859-1"))) {
				str = new String(buf, "iso-8859-1");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * 将字符串handleStr中以pointStr以分隔的每个字符串存放在向量中返回
	 * 
	 * @param handleStr
	 * @param pointStr
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Vector explode(String handleStr, String pointStr) {
		Vector v = new Vector();
		int pos1, pos2;
		try {
			if (handleStr.length() > 0) {
				pos1 = handleStr.indexOf(pointStr);
				pos2 = 0;
				while (pos1 != -1) {
					v.addElement(handleStr.substring(pos2, pos1));
					pos2 = pos1 + pointStr.length();
					pos1 = handleStr.indexOf(pointStr, pos2);
				}
				v.addElement(handleStr.substring(pos2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}

	/**
	 * 在字符串handleStr中的字符串pointStr以repStr代替
	 * 
	 * @param handleStr
	 * @param pointStr
	 * @param repStr
	 */
	public static String replace(String handleStr, String pointStr, String repStr) {
		String str = new String();
		int pos1, pos2;
		try {
			if (handleStr.length() > 0) {
				pos1 = handleStr.indexOf(pointStr);
				pos2 = 0;
				while (pos1 != -1) {
					str += handleStr.substring(pos2, pos1);
					str += repStr;
					pos2 = pos1 + pointStr.length();
					pos1 = handleStr.indexOf(pointStr, pos2);
				}
				str += handleStr.substring(pos2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * 将字符串转换为html字符串
	 * 
	 * @param handleStr
	 */
	public static String htmlSpecialChars(String handleStr) {
		return htmlSpecialChars(handleStr, true);
	}

	/**
	 * html字符串和字符串之间的互换。当seq为true时转换到html字符串
	 * 
	 * @param handleStr
	 * @param seq
	 */
	public static String htmlSpecialChars(String handleStr, boolean seq) {
		String str = handleStr;

		if (seq) {
			str = replace(str, "&", "&amp;");
			str = replace(str, "\"", "&quot;");
			str = replace(str, "<", "&lt;");
			str = replace(str, ">", "&gt;");
		} else {
			str = replace(str, "&amp;", "&");
			str = replace(str, "&quot;", "\"");
			str = replace(str, "&lt;", "<");
			str = replace(str, "&gt;", ">");
		}

		if (seq) {
			str = replace(str, "\n", "<br>");
		} else {
			str = replace(str, "<br>", "\n");
		}

		return str;
	}

	/**
	 * 将字符串中的"\n"以"<br>
	 * &nbsp;&nbsp;" 替换后返回
	 * 
	 * @param handleStr
	 */
	public static String returnChar2BR(String handleStr) {
		String str = handleStr;
		str = replace(str, "\n", "<br>&nbsp;&nbsp;");
		return str;
	}

	/**
	 * 将字符串中的"\n"以"<br>
	 * &nbsp;&nbsp;" 替换后返回
	 * 
	 * @param handleStr
	 */
	public static String returnChar2BRno(String handleStr) {
		String str = handleStr;
		if (str != null) {
			str = replace(str, "\n", "<br>");
		} else {
			str = "";
		}
		return str;
	}

	/**
	 * 将handler中的内容取出转换为字符串并将其每个以separator分割开后返回。
	 * 
	 * @param handler
	 * @param separator
	 */
	public static String implode(@SuppressWarnings("rawtypes") Vector handler, String separator) {
		StringBuffer strbuf = new StringBuffer();
		try {
			if (!handler.isEmpty()) {
				int len = handler.size();
				for (int loopi = 0; loopi < len; loopi++) {
					strbuf.append((String) handler.get(loopi));
					if (loopi != len - 1)
						strbuf.append(separator);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strbuf.toString();
	}

	/**
	 * 当字符串长度小于Len时，有字符InsChar填冲到str的左边或右边，当intDirect为0时为左，1时为右 param1: father
	 * string param2: need fill in char param3: 0 is left fill in 1 is right
	 * fill in param4: total string length after fill in char
	 */
	public static String insStr(String str, String InsChar, int intDirect, int Len) {
		int intLen = str.length();
		StringBuffer strBuffer = new StringBuffer(str);

		if (intLen < Len) {
			int inttmpLen = Len - intLen;
			for (int i = 0; i < inttmpLen; i++) {
				if (intDirect == 1) {
					str = str.concat(InsChar);
				} else if (intDirect == 0) {
					strBuffer.insert(0, InsChar);
					str = strBuffer.toString();
				}
			}
		}
		return str;
	}

	/**
	 * 返回在字符串str中，首次出现字符串divided的位置。若没有找到返回-1
	 * 
	 * @param str
	 * @param divided
	 */
	public static int searchDiv(String str, String divided) {
		try {
			divided = divided.trim();
			int divpos = -1;

			if (str.length() > 0) {
				divpos = str.indexOf(divided);

				return divpos;
			} else
				return divpos;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * 在字符串str中取首次出现startdiv到首次出现enddiv之间的字符串并返回，如果没有找到返回“”
	 * 
	 * @param str
	 * @param startdiv
	 * @param enddiv
	 */
	public static String extractStr(String str, String startdiv, String enddiv) {
		int startdivlen = startdiv.length();
		str = str.trim();

		int startpos = -1;
		int endpos = -1;

		startdiv = startdiv.trim();
		enddiv = enddiv.trim();
		startpos = searchDiv(str, startdiv);
		if (str.length() > 0) {
			if (startpos >= 0) {
				str = str.substring(startpos + startdivlen);
				str = str.trim();
			}
			endpos = searchDiv(str, enddiv);
			if (endpos == -1)
				return "";
			str = str.substring(0, endpos);
			str = str.trim();
		}
		return str;
	}

	/**
	 * 返回一个不为空的字符串
	 * 
	 * @param str
	 */
	public static String isNull(String str) {
		return isNull(str, "&nbsp;");
	}

	/**
	 * 返回一个不为空的字符串，当为空时返回def
	 * 
	 * @param str
	 * @param def
	 */
	public static String isNull(String str, String def) {
		if (str == null)
			return def;
		else if (str.length() == 0)
			return def;
		else
			return str;
	}

	/**
	 * 将字符串类型转换为整数类型
	 * 
	 * @param str
	 */
	public static int StringToInt(String str) {
		return StringToInt(str, 0);
	}

	/**
	 * 将字符串类型转换为整数类型，出错时有def值返回
	 * 
	 * @param str
	 * @param def
	 */
	public static int StringToInt(String str, int def) {
		int intRet = def;
		try {
			if (str == null || str.trim().equals(""))
				str = def + "";
			intRet = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return intRet;
	}

	/**
	 * 将字符串类型转换为浮点类型
	 * 
	 * @param str
	 */
	public static float StringToFloat(String str) {
		return StringToFloat(str, 0);
	}

	/**
	 * 将字符串类型转换为浮点类型，出错时有def值返回
	 * 
	 * @param str
	 * @param def
	 */
	public static float StringToFloat(String str, float def) {
		float fRet = def;
		try {
			if (str == null || str.trim().equals(""))
				str = "0";
			fRet = Float.parseFloat(str);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return fRet;
	}

	/**
	 * 将字符串类型转换为双精度类型
	 * 
	 * @param str
	 */
	public static double StringToDouble(String str) {
		return StringToDouble(str, (double) 0);
	}

	/**
	 * 将字符串类型转换为双精度类型，出错时有def值返回
	 * 
	 * @param str
	 * @param def
	 */
	public static double StringToDouble(String str, double def) {
		double dRet = (double) def;
		try {
			if (str == null || str.trim().equals(""))
				str = "0";
			dRet = Double.parseDouble(str);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return dRet;
	}

	/**
	 * 将字符串类型转换为双精度类型
	 * 
	 * @param str
	 */
	public static long StringToLong(String str) {
		return StringToLong(str, (long) 0);
	}

	/**
	 * 将字符串类型转换为双精度类型，出错时有def值返回
	 * 
	 * @param str
	 * @param def
	 */
	public static long StringToLong(String str, long def) {
		long dRet = (long) def;
		try {
			if (str == null || str.trim().equals(""))
				str = "0";
			dRet = Long.parseLong(str);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return dRet;
	}

	/**
	 * 获得安全字符串，使得字符串不为空，并去掉前后的空格
	 * 
	 * @param str
	 */
	public static String getSafeString(String str) {
		if (str == null)
			return "";
		else
			return str.trim();
	}

	/**
	 * 将字符串在指定的长度内显示，超出后以..代替
	 * 
	 * @param str
	 *            in string
	 * @param iLen
	 *            specify length out string
	 */
	public static String substr(String str, int iLen) {
		if (str == null)
			return "";
		if (iLen > 2) {
			if (str.length() > iLen - 2) {
				str = str.substring(0, iLen - 2) + "..";
			}

		}
		return str;
	}

	/**
	 * 将字符串在指定的长度内显示，超出部分去掉
	 * 
	 * @param str
	 *            in string
	 * @param iLen
	 *            specify length out string
	 */
	public static String substr(int iLen, String str) {
		if (str == null)
			return "";

		if (str.length() > iLen) {
			str = str.substring(0, iLen);
		}
		return str;
	}

	/**
	 * 返回以UTF-8编码的URL
	 * 
	 * @param str
	 *            handle string str[]
	 */
	public static String getUrlString(String str) {
		if (str == null) {
			return null;
		}
		try {
			return URLEncoder.encode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将对象转换了字符型
	 * 
	 * @param s
	 */
	public static String null2String(Object s) {
		return s == null || s.equals("null") || s.equals("NULL") ? "" : s.toString();
	}

	/**
	 * 运行可执行文件
	 * 
	 * @param cmd
	 * @return String
	 */
	public static synchronized boolean executeCmd(String cmd) {
		Process process = null;
		try {
			process = Runtime.getRuntime().exec(cmd);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		process.destroy();
		return true;
	}

	/**
	 * 将字符串数组转换为（'a','b'）的格式后返回，来方便数据库的操作
	 * 
	 * @param names
	 * @return String
	 */
	public static String getStrsplit(String[] names) {
		if (names == null || names.length == 0)
			return "()";
		String result = "(";
		for (int i = 0; i < names.length; i++) {
			if (i == names.length - 1)
				result = result + "'" + names[i] + "'";
			else
				result = result + "'" + names[i] + "',";
		}
		result = result + ")";
		return result;
	}

	/**
	 * 将字符串数组转换为（a,b）的格式后返回，来方便数据库的操作
	 * 
	 * @param names
	 * @return String
	 */
	public static String getIntsplit(String[] names) {
		if (names == null || names.length == 0)
			return "()";
		String result = "(";
		for (int i = 0; i < names.length; i++) {
			if (i == names.length - 1)
				result = result + "" + names[i] + "";
			else
				result = result + "" + names[i] + ",";
		}
		result = result + ")";
		return result;
	}

	/**
	 * 将列表转换为（'a','b'）的格式后返回，来方便数据库的操作
	 * 
	 * @param names
	 * @return String
	 */
	public static String getStrsplit(@SuppressWarnings("rawtypes") ArrayList names) {
		if (names == null || names.size() == 0)
			return "('')";
		String result = "(";
		for (int i = 0; i < names.size(); i++) {
			if (i == names.size() - 1)
				result = result + "'" + (String) names.get(i) + "'";
			else
				result = result + "'" + (String) names.get(i) + "',";
		}
		result = result + ")";
		return result;
	}

	/**
	 * 将整形数组转换为（1，2）的格式后返回，来方便数据库的操作
	 * 
	 * @param ids
	 * @return String
	 */
	public static String getIdsplit(Integer[] ids) {
		if (ids == null || ids.length == 0)
			return "('')";
		String result = "(";
		for (int i = 0; i < ids.length; i++) {
			if (i == ids.length - 1)
				result = result + ids[i];
			else
				result = result + ids[i] + ",";
		}
		result = result + ")";
		return result;
	}

	/**
	 * 将向量转换为（1，2）的格式后返回，来方便数据库的操作
	 * 
	 * @param ids
	 * @return String
	 */
	public static String getIdsplit(@SuppressWarnings("rawtypes") Vector ids) {
		if (ids == null || ids.size() == 0)
			return "()";
		String result = "(";
		for (int i = 0; i < ids.size(); i++) {
			if (i == ids.size() - 1)
				result = result + (String) ids.get(i);
			else
				result = result + (String) ids.get(i) + ",";
		}
		result = result + ")";
		return result;
	}

	/**
	 * 将url转换为图片的HTML代码格式
	 * 
	 * @param url
	 * @return String
	 */
	public static String toImage(String url) {
		return "<img src='" + url + "' border=0>";
	}

	/**
	 * 将url转换为图片的HTML代码格式
	 * 
	 * @param url
	 * @return String
	 */
	public static String toImage(String url, String attribute) {
		return "<img src='" + url + "' border=0 " + attribute + " >";
	}

	/**
	 * 返回树形结构的字符串为├来分级
	 * 
	 * @param level
	 * @param flag
	 * @return String
	 */
	public static String getLevelFlag(int level, String flag) {
		String temp = "";
		for (int i = 0; i < level; i++) {
			temp = temp + flag;
		}
		return temp + "├";
	}

	/**
	 * 生成随机数（含有大小写字母和数字） count 几位
	 * 
	 * @return String
	 */
	@SuppressWarnings("unchecked")
	public static String getRandom(int count) {
		@SuppressWarnings("rawtypes")
		List list = new ArrayList();
		// list.add(1);
		for (int i = 0; i < 10; i++)
			list.add(i + "");

		for (char c = 'a'; c <= 'z'; c++)
			list.add(c + "");
		for (char c = 'A'; c <= 'Z'; c++)
			list.add(c + "");

		String randomStr = "";

		for (int i = 0; i < count; i++) {
			int mathInt;
			mathInt = (int) (Math.random() * list.size());
			randomStr += (String) list.get(mathInt);
			list.remove(mathInt);
		}

		return randomStr;

	}

	/**
	 * 将list转换成以逗号分隔的字符串 如：str1,str2,str3,
	 * 
	 * @param stringList
	 * @return String
	 */
	public static String listToString(List<String> stringList) {
		if (stringList == null) {
			return null;
		}
		StringBuilder result = new StringBuilder();
		boolean flag = false;
		for (String string : stringList) {
			if (flag) {
				result.append(",");
			} else {
				flag = true;
			}
			result.append(string);
		}
		return result.toString();
	}

	/**
	 * 将以特殊符号分隔的字符串转换为('a','b')的格式后返回，来方便数据库的操作
	 * 
	 * @param names
	 *            如 a,b,c
	 * @return String 如 ('a','b','c')
	 */
	public static String getStrsplit(String names, String split) {
		String result = "";
		if (names != null && !"".equals(names) && split != null) {

			String[] nameArr = names.split(split);
			result = StringUtil.getStrsplit(nameArr);
		}
		return result;
	}

	/**
	 * 字符串处理，传入字符串为空或为null转化为0，否则转化成字符串trim后的结果
	 * 
	 * @param s
	 * @return String
	 */
	public static String null2Zero(String s) {
		if (s != null) {
			s = s.trim();
		}
		return s == null || s.equals("") || s.equals("null") || s.equals("NULL") ? "0" : s.toString();
	}

	// public static void main(String[] args){
	// 将列表转换为字符串输出----->getStrByArray(ArrayList arr, String split)
	/*
	 * ArrayList<String> arr = new ArrayList<String>(); arr.add("a");
	 * arr.add("b"); arr.add("c"); arr.add("d"); String string
	 * =getStrByArray(arr, ","); System.out.println(string);//a,b,c,d
	 */

	// 将GBK字符转化为ISO字符----------getISOFromGBK(String str)
	/*
	 * String str = "中国"; String str1 =getISOFromGBK(str);
	 * System.out.println(str1);
	 */

	// 将字符串handleStr中以pointStr以分隔的每个字符串存放在向量中返回 ------Vector explode(String
	// handleStr, String pointStr)
	/*
	 * String s1="People mountain,People sea."; String split=","; Vector vector
	 * = explode(s1,split); for(int i=0;i<vector.size();i++){
	 * System.out.println(vector.get(i));//当然split就会消失了 }
	 */

	// 在字符串handleStr中的字符串pointStr以repStr代替---------String replace(String
	// handleStr, String pointStr, String repStr)
	/*
	 * String s1="People mountain,People sea."; String split=","; String
	 * repSplit=":"; System.out.println(replace(s1,split,repSplit));//People
	 * mountain:People sea.
	 */

	// 将字符串转换为html字符串---------------public static String htmlSpecialChars(String
	// handleStr)
	/*
	 * System.out.println(htmlSpecialChars("\n没有意义"));//<br>没有意义
	 */

	// 将字符串中的"\n"以 "<br>&nbsp;&nbsp;" --------------public static String
	// returnChar2BR(String handleStr)
	/*
	 * String string = "God\nDamn it";
	 * System.out.println(returnChar2BR(string));//God<br>&nbsp;&nbsp;Damn it
	 */

	// 将向量handler中的内容取出转换为字符串并将其每个以separator分割开后返回------------------public
	// static String implode( Vector handler, String separator)
	/*
	 * Vector<String> vector = new Vector<String>(); vector.add("a");
	 * vector.add("b"); vector.add("c");
	 * System.out.println(implode(vector,","));//a,b,c
	 */

	// 当字符串长度小于Len时，有字符InsChar填冲到str的左边或右边，当intDirect为0时为左，1时为右 ----public
	// static String insStr(String str, String InsChar, int intDirect, int Len)
	/*
	 * System.out.println(insStr("Mr.Gong","ZhongYi",0,9));//Mr.Gong长度为7，
	 * 所以会插入两个ZhongYi
	 */

	// 在字符串str中取首次出现startdiv到首次出现enddiv之间的字符串并返回，如果没有找到返回"" -------------public
	// static String extractStr(String str, String startdiv, String enddiv)
	/*
	 * String string ="gongzhongyi";
	 * System.out.println(extractStr(string,"gong","yi"));//zhong
	 */

	// 返回以UTF-8编码的URL
	/*
	 * System.out.println(getUrlString("www.baidu.com?id=龚忠意"));//www.baidu.com%
	 * 3Fid%3D%E9%BE%9A%E5%BF%A0%E6%84%8F
	 */

	// 将对象转换了String类型-------------public static String null2String(Object s)
	/*
	 * System.out.println(null2String("null"));//空
	 * System.out.println(null2String("NULL"));//空 String string=null;
	 * System.out.println(null2String(string));//空
	 */

	// 运行可执行文件
	// executeCmd("D:\\Program Files
	// (x86)\\Tencent\\QQ\\QQProtect\\Bin\\QQProtect.exe");//QQ就能够启动了

	// 将字符串数组转换为（'a','b'）的格式后返回，来方便数据库的操作-------------public static String
	// getStrsplit(String[] names)
	/*
	 * String []arr={"a","b","c"};
	 * System.out.println(getStrsplit(arr));//('a','b','c')
	 */

	// 返回树形结构的字符串为├来分级 ---------------public static String getLevelFlag(int
	// level, String flag)
	/*
	 * System.out.println(getLevelFlag(1,"")+"一级菜单");
	 * System.out.println(getLevelFlag(2,"  ")+"二级菜单");
	 * System.out.println(getLevelFlag(3,"  ")+"三级菜单");
	 */

	/*
	 * ├一级菜单 ├二级菜单 ├三级菜单
	 */

	// 生成随机数（含有大小写字母和数字） count 几位-------------public static String getRandom(int
	// count)
	/*
	 * System.out.println(getRandom(5));//ckVny,count是几就返回字符串的长度就是几
	 */

	// 将list转换成以逗号分隔的字符串 如：str1,str2,str3,----- public static String
	// listToString(List<String> stringList)
	/*
	 * List a = new ArrayList(); a.add("a"); a.add("b"); a.add("c"); a.add("d");
	 * System.out.println(listToString(a));//a,b,c,d
	 */

	// 将以特殊符号分隔的字符串转换为('a','b')的格式后返回，来方便数据库的操作-------public static String
	// getStrsplit(String names, String split)
	/*
	 * System.out.println(getStrsplit("a,b,c",","));//('a','b','c')
	 */

	// 字符串处理，传入字符串为空或为null转化为0，否则转化成字符串trim后的结果-----public static String
	// null2Zero(String s)
	/*
	 * String string=null; System.out.println(null2Zero(string));//0
	 * System.out.println(null2Zero("null"));//0
	 * System.out.println(null2Zero("NULL"));//0
	 * System.out.println(null2Zero(""));//0 System.out.println(null2Zero(
	 * "      gong     "));//gong
	 */
	// }

}