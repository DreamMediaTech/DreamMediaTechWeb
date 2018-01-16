package com.dream.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dream.test.folder.Bean;
import com.dream.util.AppInterfaceUtil;
import com.google.gson.Gson;

@Controller
@RequestMapping("/MobileUserController")
public class MobileUserController {
	
	@RequestMapping("/testInterface")
	@ResponseBody
	public Map getData(HttpServletRequest request , HttpServletResponse response) throws IOException{
		Bean bean = new Bean();
		
		bean.setId(123456789);
		
		bean.setName("ÁºìÇÎÄ");
		
		
		response.setCharacterEncoding("utf-8");
		
		return AppInterfaceUtil.createResult(1, bean);
	}
	
	
	
}
