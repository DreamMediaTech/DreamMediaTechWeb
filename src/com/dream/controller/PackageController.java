package com.dream.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dream.pojo.Agents;
import com.dream.pojo.IntegralPackage;
import com.dream.pojo.Member;
import com.dream.pojo.Rule;
import com.dream.service.impl.IntegralPackageService;
import com.dream.service.impl.RuleService;

@Controller
@RequestMapping("packageController")
public class PackageController {
	@Autowired
	private IntegralPackageService integralPackageService;
	@Autowired
	private RuleService ruleService;
	
	@RequestMapping("/getallpackage")
	public ModelAndView getallpackage(ModelAndView modelAndView ,HttpServletRequest request,HttpServletResponse response,IntegralPackage integralPackage) {
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		List<IntegralPackage> list=integralPackageService.getAllPackage();
		List<Rule> rule=ruleService.getall();
		modelAndView.addObject("list", list);
		modelAndView.addObject("rule", rule);
		modelAndView.setViewName("/rate.jsp");
		return modelAndView;
	}
	@RequestMapping("/addpackage")
	public String addpackage(ModelAndView modelAndView ,HttpServletRequest request,HttpServletResponse response,IntegralPackage integralPackage) {
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		integralPackageService.insertNewPackage(integralPackage);
		return "redirect:/packageController/getallpackage.action";
	}
	@RequestMapping("/deletepackage")
	public String deletepackage(ModelAndView modelAndView ,HttpServletRequest request,HttpServletResponse response,int pid) {
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		integralPackageService.deletePackage(pid);
		return "redirect:/packageController/getallpackage.action";
	}
	@RequestMapping("/updatepackage")
	public String updatepackage(ModelAndView modelAndView ,HttpServletRequest request,HttpServletResponse response,IntegralPackage integralPackage) {
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		integralPackageService.updatePackage(integralPackage);
		return "redirect:/packageController/getallpackage.action";
	}
	
	@RequestMapping("/updaterule")
	public String updaterule(ModelAndView modelAndView ,HttpServletRequest request,HttpServletResponse response,Rule rule) {
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");	
		Agents agents=new Agents();
		Member member=new Member();
		ruleService.updaterule(rule);
		if(rule.getRuId()==1) {
			String a=rule.getRuParameter();
			int b=Integer.parseInt(a);
			member.setBate(b);
			ruleService.updatememberbate(member);
		}
		if(rule.getRuId()==2) {
			String a=rule.getRuParameter();
			float b=Float.valueOf(a);
			agents.setFirstRebate(b);
			ruleService.updatefirst(agents);
		}
		if(rule.getRuId()==3) {
			String a=rule.getRuParameter();
			float b=Float.valueOf(a);
			agents.setSecondRebate(b);
			ruleService.updatesecond(agents);
		}
		return "redirect:/packageController/getallpackage.action";
	}
	
}
