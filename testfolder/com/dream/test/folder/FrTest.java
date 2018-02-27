package com.dream.test.folder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestParam;

import com.dream.pojo.Function;
import com.dream.pojo.Role;
import com.dream.service.impl.Function_RoleService;

public class FrTest {
	ApplicationContext ac=null;
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("spring/spring-bean.xml");
	}
	/**
	 * 
	
	@Test
	public void getFunction() {
		Function_RoleService function_RoleService=(Function_RoleService)ac.getBean("functionroleservice");
		List<Function> list=function_RoleService.getFunction();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Function function = (Function) iterator.next();
			System.out.println(function.getfName());
		}
	}
	@Test
	public void getRole() {
		Function_RoleService function_RoleService=(Function_RoleService)ac.getBean("functionroleservice");
		List<Role> list=function_RoleService.getRole();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Role role = (Role) iterator.next();
			System.out.println(role.getrName());
		}
	} 
	@Test
	public void getFunctionbyRole() {
		Function_RoleService function_RoleService=(Function_RoleService)ac.getBean("functionroleservice");
		Role role =new Role();
		role.setrId(1);
		 List<Function> r=function_RoleService.getFunctionbyRole(role);
		for (Iterator iterator = r.iterator(); iterator.hasNext();) {
			Function function = (Function) iterator.next();
			System.out.println(function.getfName());
		}
		
	}
	@Test 
	public void insertRole() {
		Function_RoleService function_RoleService=(Function_RoleService)ac.getBean("functionroleservice");
		
		Role role =new Role();
		role.setrId(99);
		role.setrDescribe("测试权限");
		role.setrName("测试权限名字");
		function_RoleService.insertRole(role);
	}*/
}
