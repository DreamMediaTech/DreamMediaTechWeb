package com.dream.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dream.pojo.Member;
import com.dream.pojo.User;
import com.dream.service.impl.MemberService;

@Controller
@RequestMapping("accountController")

public class AccountController {
@Autowired
private MemberService memberService;
@RequestMapping("/getaccount")
	public ModelAndView getAccount(HttpServletRequest request,HttpServletResponse response) throws IOException{
	ModelAndView modelAndView = new ModelAndView();
	request.getSession().getAttribute("ymid");
	request.getSession().getAttribute("uid");
	request.getSession().getAttribute("uname");
	List<Member> list=memberService.queryallmember();
	modelAndView.addObject("list", list);
	modelAndView.setViewName("/account-list.jsp");

	for (Iterator iterator = list.iterator(); iterator.hasNext();) {
		Member member = (Member) iterator.next();
		System.out.println(member.getmId());
	}
	return modelAndView;
}
@RequestMapping("/queryaccount")
public ModelAndView queryaccount(HttpServletRequest request,HttpServletResponse response,Member member) throws IOException{
ModelAndView modelAndView = new ModelAndView();
request.getSession().getAttribute("ymid");
request.getSession().getAttribute("uid");
request.getSession().getAttribute("uname");
member=memberService.querymember(member);
modelAndView.addObject("member", member);
modelAndView.setViewName("/account-detail.jsp");


return modelAndView;
}
@RequestMapping("/updateaccount")
public String updateaccount(HttpServletRequest request,HttpServletResponse response,Member member) throws IOException{
request.getSession().getAttribute("ymid");
request.getSession().getAttribute("uid");
request.getSession().getAttribute("uname");
memberService.updateMember(member);
int a =member.getmId();
return "redirect:/accountController/queryaccount.action?mId="+a+"";
}


}
