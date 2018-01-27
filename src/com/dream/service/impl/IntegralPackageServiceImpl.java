package com.dream.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.mapper.IntegralPackageMapper;
import com.dream.pojo.IntegralPackage;
import com.dream.pojo.PackagePurchaseRecord;
import com.dream.pojo.User;

@Service("integralPackageService")
public class IntegralPackageServiceImpl implements IntegralPackageService{
	
	@Autowired
	private IntegralPackageMapper integralPackageMapper;

	public void insertNewPackage(IntegralPackage integralPackage){
		integralPackageMapper.insertNewPackage(integralPackage);
	}

	@Override
	public void buyPackage(User user, IntegralPackage integralPackage) {
		//交易信息认证
		
		

		
		//修改积分信息
		float BonusIntegral = user.getMemberInformation().getBonusIntegral()+integralPackage.getBonusIntegral();
		float SharingIntegral = user.getMemberInformation().getSharingIntegral()+integralPackage.getSharingIntegral();
		float ConsumptionIntegral = user.getMemberInformation().getConsumptionIntegral()+integralPackage.getConsumptionIntegral();
		user.getMemberInformation().setBonusIntegral(BonusIntegral);
		user.getMemberInformation().setConsumptionIntegral(ConsumptionIntegral);
		user.getMemberInformation().setSharingIntegral(SharingIntegral);
		integralPackageMapper.buyPackage(user.getMemberInformation());
	
		
		//增加购买记录
		PackagePurchaseRecord packagePurchaseRecord = new PackagePurchaseRecord();
		packagePurchaseRecord.setUser(user);
		packagePurchaseRecord.setIntegralPackage(integralPackage);
		//packagePurchaseRecord.setrTime(TimeUtil.getTime());
		integralPackageMapper.insertNewPurchaseRecord(packagePurchaseRecord);
		
		//返还积分给上级
		
	}

	@Override
	public List<IntegralPackage> getAllPackage() {
		return integralPackageMapper.getAllPackage();
	}
	/**
	 * 修改大礼包
	 */
	@Override
	public void updatePackage(IntegralPackage integralPackage) {
		// TODO Auto-generated method stub
		integralPackageMapper.updatePackage(integralPackage);
	};
	
	
}
