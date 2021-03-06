package com.dream.test.folder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dream.pojo.BigWithDrawals;
import com.dream.pojo.Rule;
import com.dream.pojo.User;
import com.dream.service.impl.BigWithdrawalsService;
import com.dream.service.impl.RuleService;

public class BigWithdrawalsTest {
	ApplicationContext ac=null;
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("spring/spring-bean.xml");
	}
	/**
	 * 进行提现订单修改
	
	@Test 
	public void updateapply() {
		User user = new User();
		BigWithDrawals bigWithDrawals=new  BigWithDrawals();
		user.setuId(2);
		bigWithDrawals.setBwRespinsibility(user);
		bigWithDrawals.setBwState("通过");
		bigWithDrawals.setBwId(999);
		BigWithdrawalsService bigWithdrawalsService =(BigWithdrawalsService)ac.getBean("bigwithdrawalsservice");
		bigWithdrawalsService.updateapply(bigWithDrawals);
	} */
	/**
	 * 进行订单查询
	 */
	@Test
	public void queryallapply() {
		BigWithdrawalsService bigWithdrawalsService =(BigWithdrawalsService)ac.getBean("bigwithdrawalsservice");
		
		List<BigWithDrawals> list= bigWithdrawalsService.queryallapply();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			BigWithDrawals bigWithDrawals = (BigWithDrawals) iterator.next();
			
			System.out.println(bigWithDrawals.getuId().getuName());
		}
	}
	/**
	 * app响应提出申请提现  测试通过
	 
	@Test 
	public void insertbwd() {
		BigWithDrawals bigWithDrawals =new BigWithDrawals();
		User user=new User();
		user.setuId(1);
		bigWithDrawals.setUser(user);
		bigWithDrawals.setBwId(999);
		bigWithDrawals.setBwState("待审核");
		bigWithDrawals.setMoney(6000);
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		bigWithDrawals.setBwTime(df.format(now));
		BigWithdrawalsService bigWithdrawalsService =(BigWithdrawalsService)ac.getBean("bigwithdrawalsservice");
		bigWithdrawalsService.insertbwd(bigWithDrawals);
	}*/
	/**
	 * 
	 
	@Test
	public void queryallapply() {
		RuleService ruleService =(RuleService)ac.getBean("ruleService");
		Rule rule =new Rule();
		rule.setRuId(1);
		rule.setRuParameter("12");
		ruleService.updaterule(rule);
	}	*/
}
