package com.dream.util;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class AppInterfaceUtil {
	
	public static Map<String,Object> createResult(int code,Object data,Map<String, Object> params){

		Map<String, Object> result = new HashMap<String,Object>();
		
		
		if(params!=null){
			result.putAll(params);
		}
		if(data!=null){
			result.put("data", data);
		}
		result.put("status", code);
		return result;
	}
	
}
