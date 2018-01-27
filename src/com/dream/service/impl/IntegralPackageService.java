package com.dream.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dream.pojo.IntegralPackage;
import com.dream.pojo.User;


public interface IntegralPackageService {
	
	public void insertNewPackage(IntegralPackage integralPackage);//添加新礼包
	
	public void updatePackage(IntegralPackage integralPackage);//修改大礼包
	
	public void buyPackage(User user , IntegralPackage integralPackage);//购买礼包
	
	public List<IntegralPackage> getAllPackage();//获取所有礼包

}
