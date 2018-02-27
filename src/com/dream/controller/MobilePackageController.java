package com.dream.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dream.pojo.IntegralPackage;
import com.dream.pojo.User;
import com.dream.service.impl.IntegralPackageService;
import com.dream.util.AppInterfaceUtil;

@Controller
@RequestMapping("/mobilePackageController")
public class MobilePackageController {
	private static final int SUCCESS_CODE = 200;
	private static final int DATA_NOT_FOUND = 3;
	
	@Autowired
	IntegralPackageService integralPackageService;
	
	/**
	 * APP获取所有礼包信息
	 * @return
	 */
	@RequestMapping(value="/getAllPackage",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Map<String, Object> getAllPackage(){
		List<IntegralPackage> list = integralPackageService.getAllPackage();
		return AppInterfaceUtil.createResult(SUCCESS_CODE,list,null);
	}

	/**
	 * 用户购买礼包
	 * @param uid 用户编号
	 * @param pid 礼包编号
	 * @return
	 */
	@RequestMapping(value="/userBuyPackage",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Map<String,Object> userBuyPackage(int uid,int pid){
		//支付宝对账
		integralPackageService.buyPackage(uid, pid);
		return AppInterfaceUtil.createResult(SUCCESS_CODE, null, null);
	}
	
	/**
	 * 获取礼包信息
	 * @param pid 礼包编号
	 * @return
	 */
	@RequestMapping(value="/getPackageByid",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Map<String,Object> getPackageByid(int pid){
		//支付宝对账
		IntegralPackage integralPackage = integralPackageService.getPackageById(pid);
		if(integralPackage!=null){
			return AppInterfaceUtil.createResult(SUCCESS_CODE,integralPackage, null);
		}
		else{
			return AppInterfaceUtil.createResult(DATA_NOT_FOUND, integralPackage, null);
		}
	}
	
}
