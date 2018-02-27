package com.dream.test.folder;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dream.pojo.Function;
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
//	/**
//	 * 测试根据uid查询进行登陆
//	 */
//	@Test
//	public void queryuser() {
//		User user=new User();
//	user.setYmId("ym001");
//	UserService userService=(UserService) ac.getBean("userservice");
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
	/**
	 * 
	 
	@Test
	public void registerByShare(){
		UserService userService=(UserService) ac.getBean("userservice");
		if(userService.checkPhone("114")){
			User user  = new User();
			user.setuId(1);
			userService.registerUser("114", Encoder.EncoderByMd5("456"),user);
		}
	}
//	*/
//	@Test
//	public void checkPhoneTest(){
//		UserService userService=(UserService) ac.getBean("userservice");
//		System.out.println(userService.checkPhone("123456"));
//	}
//	
//	/	
//	@Test
//	public void login(){
////		UserService userService=(UserService) ac.getBean("userservice");
////		userService.queryUserByPhone("13538601622");
//		UserMapper userMapper = (UserMapper) ac.getBean("userMapper");
//		User user = new User();
//		user.setuId(29);
//		List<Role> list = new ArrayList<Role>();
//		Role role = new Role();
//		Role role_1 = new Role();
//		role_1.setrId(2);
//		role.setrId(1);
//		role_1.setrId(2);
//		list.add(role);
//
//		list.add(role_1);
//		user.setRoles(list);
//		userMapper.getFunctionByRole(user.getRoles());
//	}
//	
//	@Test
//	public void updateUserInformation(){
//		UserService userService=(UserService) ac.getBean("userservice");
//		User user= new User();
//		user.setuId(29);
//		user.setuName("梁烨文");
//		user.setuSex("男");
//		user.setuNickName("wx_shadow");
//		user.setuImage("123");
//		user.setuImageAddress("456");
//		userService.updateUser(user);
//	}
	@Test
	public void getFunctionTest(){
		UserService userService=(UserService) ac.getBean("userservice");
		User user = new User();
		user.setuId(29);
		userService.getRoleAndFunction(user);
		
		for(Function function:user.getFunctions()){
			System.out.println(function.getfId() + function.getfName() + function.getfState());
		}
	}

}
