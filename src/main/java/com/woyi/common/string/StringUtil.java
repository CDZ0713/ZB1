package com.woyi.common.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	public static String camel4underline(String param){  
        Pattern  p=Pattern.compile("[A-Z]");  
        if(param==null ||param.equals("")){  
            return "";  
        }  
        StringBuilder builder=new StringBuilder(param);  
        Matcher mc=p.matcher(param);  
        int i=0;  
        while(mc.find()){  
            builder.replace(mc.start()+i, mc.end()+i, "_"+mc.group().toLowerCase());  
            i++;  
        }  
  
        if('_' == builder.charAt(0)){  
            builder.deleteCharAt(0);  
        }  
        return builder.toString();  
    } 
}
