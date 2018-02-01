package com.dream.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dream.pojo.BigWithDrawals;
import com.dream.pojo.IntegralPackage;
import com.dream.service.impl.BigWithdrawalsService;

@Controller
@RequestMapping("/otherController")
public class OtherController {

	@Autowired
	private BigWithdrawalsService bigWithdrawalsService;
	@RequestMapping("/getallwithdrawal")
	public ModelAndView getallwithdrawal(ModelAndView modelAndView ,HttpServletRequest request,HttpServletResponse response,BigWithDrawals bigWithDrawals) {
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		List<BigWithDrawals> list=bigWithdrawalsService.queryallapply();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("/withdraw.jsp");
		return modelAndView;
	}
}
