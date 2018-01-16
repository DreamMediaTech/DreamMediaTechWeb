package com.dream.test.folder;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dream.service.impl.MemberService;

public class MemberTest {
	ApplicationContext ac=null;
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("spring/spring-bean.xml");
	}
	@Test
	public void queryallmember() {
		MemberService memberService=(MemberService)ac.getBean("memberservice");
		memberService.queryallmember();
	}
}
