package com.dream.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dream.pojo.Function;
import com.dream.pojo.Member;
import com.dream.pojo.Role;
import com.dream.pojo.User;
import com.dream.service.impl.AgentService;
import com.dream.service.impl.MemberService;
import com.dream.service.impl.UserService;
import com.dream.service.impl.VideoService;
import com.dream.test.folder.Bean;
import com.dream.util.AppInterfaceUtil;
import com.dream.util.Encoder;
import com.dream.util.PasswordEncoder;
import com.google.gson.Gson;

@Controller
@RequestMapping("/mobileUserController")
public class MobileUserController {
	private static final int SUCCESS_CODE=200;
	private static final int PHONE_EXIST_CODE=3;
	private static final int PASSWORD_ERROR_CODE=500;
	private static final int USER_UMEXIST_CODE=3;
	private static final int USER_FROZEN=4;

	@Autowired
	UserService userService;
	
	@Autowired
	AgentService agentService;
	
	@Autowired
	MemberService memberService ;
	
	@RequestMapping(value="/registerAppNewUser",
			produces={"application/json;charset=UTF-8"},
			method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> registerAppNewUser(String phone,String password,User Introducer){
		Map<String,Object> result = new HashMap<String, Object>();
		if(!userService.checkPhone(phone)){//判断电话号码能否注册
			result=AppInterfaceUtil.createResult(PHONE_EXIST_CODE, null,null);
		}else{
			userService.registerUser(phone, password, Introducer);
			result = AppInterfaceUtil.createResult(SUCCESS_CODE, null,null);
		}
		return result;
	}
	
	
	@RequestMapping(value="/AppLogin",
			produces={"application/json;charset=UTF-8"},
			method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object>  AppLogin(String phone,String password,HttpSession session){
		User user = userService.queryUserByPhone(phone);
		Map<String,Object> result=null;
//		String result = null;
		boolean rank = false;
			if(user==null){
				result=AppInterfaceUtil.createResult(USER_UMEXIST_CODE, null,null);
			}else{
				for(Function function :user.getFunctions()){
					if (function.getfId()==1) {
						rank = true;
					}
				}
				if(rank){
					if(user.getuPassword().equals(PasswordEncoder.EncoderByMd5(password))){
						for(Role role:user.getRoles()){
							if(role.getrName().equals("会员")){
								user.setuType("会员");
							}if(role.getrName().equals("VIP会员")){
								user.setuType("VIP会员");
							}if(role.getrName().equals("视频创作者")){
								user.setuType("视频创作者");
							}if(role.getrName().equals("代理商")){
								user.setuType("代理商");
								user.setAgentsInformation(agentService.queryagentsByUser(user));
							}
							}
						result = AppInterfaceUtil.createResult(SUCCESS_CODE,user,null);
//						result = new Gson().toJson(user);
						session.setAttribute("User", user);
						}
					else{
						result = AppInterfaceUtil.createResult(PASSWORD_ERROR_CODE, null,null);
					}
				}else{
					result = AppInterfaceUtil.createResult(USER_FROZEN, null,null);
				}

			}
			return result;
	}
	
	@RequestMapping(value="/getUserInformation",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Map<String,Object> getUserInformation(int uid){
		User user = userService.getUserInformationById(uid);
		for(Role role:user.getRoles()){
			if(role.getrName().equals("会员")){
				user.setuType("会员");
			}if(role.getrName().equals("VIP会员")){
				user.setuType("VIP会员");
			}if(role.getrName().equals("视频创作者")){
				user.setuType("视频创作者");
			}if(role.getrName().equals("代理商")){
				user.setuType("代理商");
				user.setAgentsInformation(agentService.queryagentsByUser(user));
			}
			}
		return AppInterfaceUtil.createResult(SUCCESS_CODE, user, null);
	}
	
	@RequestMapping(value="/getIntegral",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Map<String,Object> getIntegral(int uid){
		Member member = memberService.queryIntegral(uid);
		return AppInterfaceUtil.createResult(SUCCESS_CODE, member, null);
	}
	
	@RequestMapping(value="/changeUserPasswordByPhone",
			produces={"application/json;charset=UTF-8"},
			method=RequestMethod.POST)
	@ResponseBody
	public  Map<String,Object> changeUserPasswordByPhone(int uid,String newPassword){
		User user= new User();
		user.setuId(uid);
		user.setuPassword(PasswordEncoder.EncoderByMd5(newPassword));
		userService.updatePassword(user);
		return AppInterfaceUtil.createResult(SUCCESS_CODE, null, null);
	}
}
