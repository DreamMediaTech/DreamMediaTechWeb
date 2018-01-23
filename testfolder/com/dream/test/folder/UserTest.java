package com.dream.test.folder;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dream.pojo.Role;
import com.dream.pojo.User;
import com.dream.service.impl.UserService;
import com.dream.util.Encoder;



public class UserTest {
	ApplicationContext ac=null;
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("spring/spring-bean.xml");
	}
	/**
	 * 测试根据uid查询进行登陆
	 */
//	@Test
//	public void queryuser() {
//		User user=new User();
//		user.setYmId("ym001");
//		UserService userService=(UserService) ac.getBean("userservice");
//		user=userService.queryuser(user);
//		System.out.println(user.getuName()+"\t"+user.getuPhone()+"\t"+user.getuSex()  );
//	}
//	
//	@Test
//	public void getRole() {
//		
//		UserService userService=(UserService) ac.getBean("userservice");
//		userService.getRoleById(1);
//		
//	}
//	
//	@Test
//	public void defineUserToRole(){
//		UserService userService=(UserService) ac.getBean("userservice");
//		userService.defineRoleToUser(1, 1);
//	}
//	
//	@Test
//	public void register(){
//		UserService userService=(UserService) ac.getBean("userservice");
//		if(userService.checkPhone("12345")){
//			userService.registerUser("12345", Encoder.EncoderByMd5("456"),null);
//		}
//	}
	@Test
	public void registerByShare(){
		UserService userService=(UserService) ac.getBean("userservice");
		if(userService.checkPhone("114")){
			User user  = new User();
			user.setuId(1);
			userService.registerUser("114", Encoder.EncoderByMd5("456"),user);
		}
	}
//	
//	@Test
//	public void checkPhoneTest(){
//		UserService userService=(UserService) ac.getBean("userservice");
//		System.out.println(userService.checkPhone("123456"));
//	}
//	
//	@Test
//	public void login(){
//		UserService userService=(UserService) ac.getBean("userservice");
//		userService.appLogin("1234", Encoder.EncoderByMd5("456"));
//	}
	

}
