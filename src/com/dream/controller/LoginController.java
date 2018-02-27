package com.dream.controller;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dream.pojo.User;
import com.dream.service.impl.UserService;
import com.dream.util.PasswordEncoder;

@Controller
@RequestMapping("loginController")
public class LoginController {
	@Autowired
	private UserService userService;
	/**
	 * 网页登陆方法跳转
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws IOException
	 */

	@RequestMapping("/weblogin")
	public ModelAndView weblogin(HttpServletRequest request,HttpServletResponse response,User user) throws IOException{
		ModelAndView modelAndView = new ModelAndView();
		User ymid=userService.queryuser(user);
		if(ymid!=null&&ymid.getuPassword().equals(PasswordEncoder.EncoderByMd5(user.getuPassword()))) {
			request.getSession().setAttribute("ymid", ymid.getYmId());
			request.getSession().setAttribute("uid", ymid.getuId());
			request.getSession().setAttribute("uname", ymid.getuName());
			modelAndView.setViewName("/index.jsp");
		}
		else {modelAndView.setViewName("/login.jsp");}
		return modelAndView;
	}

}

