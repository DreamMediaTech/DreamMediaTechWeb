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
	 * 测试通过更新礼包
	 */
	@Test 
	public void updatepackage() {
		IntegralPackageService integralPackageService = (IntegralPackageService) ac.getBean("integralPackageService");
		IntegralPackage integralPackage =new  IntegralPackage();
		integralPackage.setPrice(12);
		integralPackage.setpId(11);
		integralPackage.setpName("12元礼包");
		integralPackage.setBonusIntegral(12);
		integralPackage.setConsumptionIntegral(13);
		integralPackage.setSharingIntegral(14);
		integralPackage.setvipQuota(3);
		integralPackageService.updatePackage(integralPackage);
	}
	/**
	 * 测试通过更新礼包
	 
	@Test
	public void buyPackage(){
		IntegralPackageService integralPackageService = (IntegralPackageService) ac.getBean("integralPackageService");
		integralPackageService.buyPackage(1,2 );
	}*/
//	
//	@Test
//	public void getAllPackage(){
//		IntegralPackageService integralPackageService = (IntegralPackageService) ac.getBean("integralPackageService");
//		List<IntegralPackage> list = integralPackageService.getAllPackage();
//		System.out.println(list.size());
//	}
//	
//	@Test
//	public void getPackage(){
//		IntegralPackageService integralPackageService = (IntegralPackageService) ac.getBean("integralPackageService");
//		IntegralPackage i = integralPackageService.getPackageById(2);
//		System.out.println(i.getpName());
//	}
}
