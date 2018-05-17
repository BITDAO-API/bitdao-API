package com.guanyou.hibtc.until;


import java.util.regex.Pattern;

/**
 * StringUtil
 * @author seif
 *
 */
public class StringUtil {
	public static String buildString(Object... argv){
		StringBuilder sb=new StringBuilder();
		for(Object o:argv){
			sb.append(o);
		}
		return sb.toString();
	}

	public static String subString(String source,String start,String end){
		return source.substring(source.indexOf(start)+1, source.indexOf(end,source.indexOf(start)+1));
	}
	
	public static String toFirstLetterUp(String s){
		if(isEmpty(s)){
			return s;
		}
		return buildString(s.substring(0, 1).toUpperCase(),s.substring(1, s.length()));
	}
	
	public static String toFirstLetterLower(String s){
		if(isEmpty(s)){
			return s;
		}
		return buildString(s.substring(0, 1).toLowerCase(),s.substring(1, s.length()));
	}
	
	public static boolean isEmpty(String s){
		return s == null || s.isEmpty() || "null".equalsIgnoreCase(s.trim());
	}

	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}
	
}
