package com.dream.util;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class AppInterfaceUtil {
	private static final  Map<Integer, String> CODEMAP = new HashMap<Integer,String>();//���ر�ż���Ϣ����
	private static Gson gson = new Gson();
	
	public static void init(){
		if(CODEMAP.size()==0){
			CODEMAP.put(0, "success");
			CODEMAP.put(1, "�û�����������");
		}
	}
	
	public static Map<String,Object> createResult(int code,Object data){
		init();

		Map<String, Object> Result = new HashMap<String,Object>();
		
		Result.put("code", code);
		Result.put("message", CODEMAP.get(code));
		Result.put("data", gson.toJson(data));
		
		return Result;
	}
	
}
