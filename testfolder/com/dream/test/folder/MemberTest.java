package com.dream.test.folder;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dream.pojo.Member;
import com.dream.service.impl.Function_RoleService;
import com.dream.service.impl.MemberService;

public class MemberTest {
	ApplicationContext ac=null;
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("spring/spring-bean.xml");
	}
	/**
	 * 测试查询所有会员信息包括user表
	 
	@Test
	public void queryallmember() {
		MemberService memberService=(MemberService)ac.getBean("memberservice");
		memberService.queryallmember();
	}*/
	/**
	 * 测试查询单个会员信息包括user表
 
	@Test
	public void querymember() {
		Member member=new Member();
		member.setmId(800);
		MemberService memberService=(MemberService)ac.getBean("memberservice");
		member=memberService.querymember(member);
		System.out.println(member.getUser().getYmId());
	}*/
	/**
	 * 测试创建新用户
	 
	@Test
	public void createMember(){
		MemberService memberService=(MemberService)ac.getBean("memberservice");
		Member newMember = memberService.createMember(null);
		System.out.println(newMember.getmId());
	}*/
	
	
	/**
	 * 测试模糊查询
*/
	@Test
	public void querymember() {
		int rid=7;
		List<Integer> fid=new ArrayList<>();
		fid.add(12);
		fid.add(11);
		fid.add(5);
		Function_RoleService f=(Function_RoleService)ac.getBean("functionroleservice");
		f.insertFunction(rid, fid);
	} 
}
