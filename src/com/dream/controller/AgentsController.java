package com.dream.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dream.pojo.AgentRequest;
import com.dream.pojo.Agents;
import com.dream.service.impl.AgentService;

@Controller
@RequestMapping("agencyController")
public class AgentsController {
	@Autowired
	private AgentService agentService;
	@RequestMapping("/getapply")
	public ModelAndView queryapply(HttpServletRequest request,HttpServletResponse response) throws IOException{
		ModelAndView modelAndView=new ModelAndView();
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		List<AgentRequest>list=  agentService.queryallapply();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("/agency-apply.jsp");
		return modelAndView;
	}
	@RequestMapping("/getagents")
	public ModelAndView getagents(HttpServletRequest request,HttpServletResponse response) throws IOException{
		ModelAndView modelAndView=new ModelAndView();
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		List<Agents>list=  agentService.queryallagents();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("/agency-list.jsp");
		return modelAndView;
	}
	@RequestMapping("/queryagents")
	public ModelAndView queryagents(HttpServletRequest request,HttpServletResponse response,Agents agents) throws IOException{
		ModelAndView modelAndView=new ModelAndView();
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		agents=  agentService.queryagents(agents);
		modelAndView.addObject("agents", agents);
		modelAndView.setViewName("/agency-detail.jsp");
		return modelAndView;
	}
	@RequestMapping("/updateagents")
	public String updateagents(HttpServletRequest request,HttpServletResponse response,Agents agents) throws IOException{
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		 agentService.updateagents(agents);
		return "redirect:/agencyController/queryagents.action?agId="+agents.getAgId()+"";
	}
}
