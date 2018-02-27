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
import com.dream.util.TimeUtil;

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
	@RequestMapping("/getoffapply")
	public ModelAndView queryoffapply(HttpServletRequest request,HttpServletResponse response,AgentRequest agentRequest) throws IOException{
		ModelAndView modelAndView=new ModelAndView();
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		List<AgentRequest>list=  agentService.queryoffapply(agentRequest);
		modelAndView.addObject("list", list);
		modelAndView.setViewName("/agency-apply.jsp");
		return modelAndView;
	}
	
	@RequestMapping("/getnoapply")
	public ModelAndView querynoapply(HttpServletRequest request,HttpServletResponse response,AgentRequest agentRequest) throws IOException{
		ModelAndView modelAndView=new ModelAndView();
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		List<AgentRequest>list=  agentService.querynoapply(agentRequest);
		modelAndView.addObject("list", list);
		modelAndView.setViewName("/agency-apply.jsp");
		return modelAndView;
	}
	
	@RequestMapping("/getonapply")
	public ModelAndView queryonapply(HttpServletRequest request,HttpServletResponse response,AgentRequest agentRequest) throws IOException{
		ModelAndView modelAndView=new ModelAndView();
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		List<AgentRequest>list=  agentService.queryonapply(agentRequest);
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
		 int a=agents.getAgId();
		return "redirect:/agencyController/queryagents.action?agId="+a+"";
	}
	
	@RequestMapping("/updateagentsapplyy")
	public String updateagentsapplyy(HttpServletRequest request,HttpServletResponse response,AgentRequest agentRequest,Agents agents,int mId) throws IOException{
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		agentRequest.setArResponsibility((int)request.getSession().getAttribute("uid"));
		agentRequest.setArState("通过");
		agentRequest.setArtoTime(TimeUtil.getTimeToSecond());
		agentRequest.setArName((String)request.getSession().getAttribute("uname"));
		if( agentService.updateAgentapply(agentRequest)) {
			agents.setArea("未指定");
			int agId=agentService.insertAgents(agents);
			System.out.println(agId);
			agentService.insertagentsintouser(agId, mId);
			agents=agentService.queryrebate();		
			agents.setAgId(agId);
			agentService.updateRebate(agents);
		}
		return "redirect:/agencyController/getapply.action";
	}
	@RequestMapping("/updateagentsapplyn")
	public String updateagentsapplyn(HttpServletRequest request,HttpServletResponse response,AgentRequest agentRequest) throws IOException{
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		agentRequest.setArResponsibility((int)request.getSession().getAttribute("uid"));
		agentRequest.setArState("未通过");
		agentRequest.setArtoTime(TimeUtil.getTimeToSecond());
		agentRequest.setArName((String)request.getSession().getAttribute("uname"));
		 agentService.updateAgentapply(agentRequest);
		return "redirect:/agencyController/getapply.action";
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param agents
	 * @return
	 * @throws IOException
	比例有问题
	@RequestMapping("/updatefrebate")
	public String updatefrebate(HttpServletRequest request,HttpServletResponse response,Agents agents) throws IOException{
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		 agentService.updatefrebate(agents);
		return "redirect:/packageController/getallpackage.action";
	}
	@RequestMapping("/updatesrebate")
	public String updatesrebate(HttpServletRequest request,HttpServletResponse response,Agents agents) throws IOException{
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		 agentService.updatesrebate(agents);
		return "redirect:/packageController/getallpackage.action";
	} */
	
	
	
}
