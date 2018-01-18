package com.dream.test.folder;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dream.pojo.BigWithDrawals;
import com.dream.pojo.User;
import com.dream.service.impl.BigWithdrawalsService;

public class BigWithdrawalsTest {
	ApplicationContext ac=null;
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("spring/spring-bean.xml");
	}
	/**
	 * 进行提现订单修改
	 */
	@Test 
	public void updateapply() {
		User user = new User();
		BigWithDrawals bigWithDrawals=new  BigWithDrawals();
		user.setuId(2);
		bigWithDrawals.setBwRespinsibility(user);
		bigWithDrawals.setBwState("通过");
		bigWithDrawals.setBwId(909);
		BigWithdrawalsService bigWithdrawalsService =(BigWithdrawalsService)ac.getBean("bigwithdrawalsservice");
		bigWithdrawalsService.updateapply(bigWithDrawals);
	}
	/**
	 * 进行订单查询
	 */
	@Test
	public void queryallapply() {
		BigWithdrawalsService bigWithdrawalsService =(BigWithdrawalsService)ac.getBean("bigwithdrawalsservice");
		bigWithdrawalsService.queryallapply();
	}

}
