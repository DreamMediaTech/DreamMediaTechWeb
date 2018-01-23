package com.dream.mapper;

import java.util.List;

import com.dream.pojo.IntegralPackage;
import com.dream.pojo.Member;
import com.dream.pojo.PackagePurchaseRecord;
import com.dream.pojo.User;

public interface IntegralPackageMapper {
	
	public void insertNewPackage(IntegralPackage integralPackage);//添加新礼包
	
	public void buyPackage(Member member);//修改积分
	
	public void insertNewPurchaseRecord(PackagePurchaseRecord packagePurchaseRecord); //增加购买记录
	
	public void deletePackage(int pid);//删除礼包
	
	public List<IntegralPackage> getAllPackage();//获取所有礼包
}
