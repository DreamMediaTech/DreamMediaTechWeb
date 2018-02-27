package com.dream.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dream.pojo.Function;
import com.dream.pojo.Role;
import com.dream.service.impl.Function_RoleService;

import com.google.gson.Gson;

@Controller
@RequestMapping("function_roleController")
public class Function_RoleController {
@Autowired
private Function_RoleService function_RoleService;

@RequestMapping("/queryrole")
public ModelAndView queryrole(HttpServletRequest request,HttpServletResponse response) throws Exception{
	ModelAndView modelAndView=new ModelAndView();
	request.getSession().getAttribute("ymid");
	request.getSession().getAttribute("uid");
	request.getSession().getAttribute("uname");
	List<Role> role=function_RoleService.getRole();
	List<Function> function =function_RoleService.getFunction();
	modelAndView.addObject("role", role);
	modelAndView.addObject("function", function);
	modelAndView.setViewName("/role-list.jsp");
	return modelAndView;
	
}



@RequestMapping("/deleterole")
public String deleterole(HttpServletRequest request,HttpServletResponse response,Role role) throws Exception{
	request.getSession().getAttribute("ymid");
	request.getSession().getAttribute("uid");
	request.getSession().getAttribute("uname");
	function_RoleService.deleteRole(role);
	return "redirect:/function_roleController/queryrole.action";
	
}
@RequestMapping("/queryonerole")
public ModelAndView queryonerole(HttpServletRequest request,HttpServletResponse response,Role role) throws Exception{
	ModelAndView modelAndView=new ModelAndView();
	request.getSession().getAttribute("ymid");
	request.getSession().getAttribute("uid");
	request.getSession().getAttribute("uname");
	List<Function> list=function_RoleService.getFunctionbyRole(role);
	List<Function> function=function_RoleService.getFunction();
	List<Function> unfunction=function_RoleService.getunFunctionbyRole(role);
	role= function_RoleService.queryrole(role);
	request.getSession().setAttribute("rid", role.getrId());
	modelAndView.addObject("list", list);
	modelAndView.addObject("role", role);
	modelAndView.addObject("unfunction", unfunction);
	modelAndView.addObject("function", function);
	modelAndView.setViewName("/edit-role.jsp");
	return modelAndView;
}
@RequestMapping("/insertFunction")
public String insertFunction(HttpServletRequest request,HttpServletResponse response,Role role,@RequestParam("fids") String[]  fids,@RequestParam("rid") int rid) throws Exception{
	request.getSession().getAttribute("ymid");
	request.getSession().getAttribute("uid");
	request.getSession().getAttribute("uname");
	List<Integer> fid=new ArrayList<Integer>();
	for(String id:fids){
		fid.add(Integer.parseInt(id));
		
	}
	function_RoleService.insertFunction(rid, fid);
	int a =(int) request.getSession().getAttribute("rid");
	return "redirect:/function_roleController/queryonerole.action?rId="+a+"";
	
}
@RequestMapping("/deleteFunctionbyrole")
public String deleteFunctionbyrole(HttpServletRequest request,HttpServletResponse response,@RequestParam("fids") String[]  fids) throws Exception{
	request.getSession().getAttribute("ymid");
	request.getSession().getAttribute("uid");
	request.getSession().getAttribute("uname");
	int a =(int) request.getSession().getAttribute("rid");
	List<Integer> fid=new ArrayList<Integer>();
	for(String id:fids){
		fid.add(Integer.parseInt(id));
		
	}
	function_RoleService.deleteFunctionbyrole(fid);
	return "redirect:/function_roleController/queryonerole.action?rId="+a+"";
	
}
@RequestMapping("/updateRole")
public String updateRole(HttpServletRequest request,HttpServletResponse response,Role role) throws Exception{
	request.getSession().getAttribute("ymid");
	request.getSession().getAttribute("uid");
	request.getSession().getAttribute("uname");	
	function_RoleService.updateRole(role);
	int a =(int) request.getSession().getAttribute("rid");
	return "redirect:/function_roleController/queryonerole.action?rId="+a+"";
	
}
@RequestMapping("/insertRole")
public String insertRole(HttpServletRequest request,HttpServletResponse response,Role role,@RequestParam("fids") String[]  fids) throws Exception{
	request.getSession().getAttribute("ymid");
	request.getSession().getAttribute("uid");
	request.getSession().getAttribute("uname");
	int rid=function_RoleService.insertRole(role);
	List<Integer> fid=new ArrayList<Integer>();
	for(String id:fids){
		fid.add(Integer.parseInt(id));
		
	}
	function_RoleService.insertFunction(rid, fid);
	return "redirect:/function_roleController/queryrole.action";
	
}
}
