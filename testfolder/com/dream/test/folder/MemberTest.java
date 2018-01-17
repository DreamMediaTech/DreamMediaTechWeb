package com.dream.test.folder;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dream.pojo.Member;
import com.dream.service.impl.MemberService;

public class MemberTest {
	ApplicationContext ac=null;
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("spring/spring-bean.xml");
	}
	/**
	 * 测试查询所有会员信息包括user表
	 */
	@Test
	public void queryallmember() {
		MemberService memberService=(MemberService)ac.getBean("memberservice");
		memberService.queryallmember();
	}
	/**
	 * 测试查询单个会员信息包括user表
	 */
	@Test
	public void querymember() {
		Member member=new Member();
		member.setmId(2018);
		MemberService memberService=(MemberService)ac.getBean("memberservice");
		member=memberService.querymember(member);
		System.out.println(member.getUser().getuId());
	}
}