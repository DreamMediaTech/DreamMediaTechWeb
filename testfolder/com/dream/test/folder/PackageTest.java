package com.dream.test.folder;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dream.pojo.IntegralPackage;
import com.dream.pojo.Member;
import com.dream.pojo.User;
import com.dream.service.impl.IntegralPackageService;
import com.dream.service.impl.MemberService;

public class PackageTest {
	ApplicationContext ac=null;
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("spring/spring-bean.xml");
	}
	/**
	 * 测试添加新礼包
	 */
//	@Test
//	public void insertNewPackageTest() {
//		IntegralPackage integralPackage = new IntegralPackage();
//		integralPackage.setpName("10元礼包");
//		integralPackage.setPrice(10);
//		integralPackage.setSharingIntegral(4);
//		integralPackage.setBonusIntegral(10);
//		integralPackage.setConsumptionIntegral(0);
//		integralPackage.setSuperQuota(0);
//		IntegralPackageService integralPackageService = (IntegralPackageService) ac.getBean("integralPackageService");
//		integralPackageService.insertNewPackage(integralPackage);
//	}
	/**
	 * 
	 
	@Test
	public void buyPackage(){
		IntegralPackageService integralPackageService = (IntegralPackageService) ac.getBean("integralPackageService");
		User user = new User();
		user.setuId(24);
		Member member = new Member();
		member.setmId(826);
		member.setBonusIntegral(0);
		member.setConsumptionIntegral(0);
		member.setSharingIntegral(0);
		member.setSuperQuota(0);
		user.setMemberInformation(member);
		
		List<IntegralPackage> packages =integralPackageService.getAllPackage();
		
		
		
		integralPackageService.buyPackage(user, packages.get(0));
	}
	*/
	/**
	 * 测试通过更新礼包
	 
	@Test 
	public void updatepackage() {
		IntegralPackageService integralPackageService = (IntegralPackageService) ac.getBean("integralPackageService");
		IntegralPackage integralPackage =new  IntegralPackage();
		integralPackage.setPrice(12);
		integralPackage.setpId(1);
		integralPackage.setpName("12元礼包");
		integralPackage.setBonusIntegral(12);
		integralPackage.setConsumptionIntegral(13);
		integralPackage.setSharingIntegral(14);
		integralPackage.setSuperQuota(3);
		integralPackageService.updatePackage(integralPackage);
	}*/
}
