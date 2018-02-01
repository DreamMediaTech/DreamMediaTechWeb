package com.dream.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dream.pojo.IntegralPackage;
import com.dream.service.impl.IntegralPackageService;

@Controller
@RequestMapping("packageController")
public class PackageController {
	@Autowired
	private IntegralPackageService integralPackageService;
	
	@RequestMapping("/getallpackage")
	public ModelAndView getallpackage(ModelAndView modelAndView ,HttpServletRequest request,HttpServletResponse response,IntegralPackage integralPackage) {
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		List<IntegralPackage> list=integralPackageService.getAllPackage();
		modelAndView.addObject("list", list);
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
	
}
