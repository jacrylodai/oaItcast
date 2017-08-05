package com.ldp.oa.utils.validate;

public class StringUtil {

	public static boolean isEmpty(String str){
		if(str == null || str.length() ==0){
			return true;
		}
		if(str.trim().length()==0){
			return true;
		}
		return false;
	}
	
}
