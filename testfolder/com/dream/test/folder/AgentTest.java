package com.dream.test.folder;

import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dream.pojo.AgentRequest;
import com.dream.pojo.Agents;
import com.dream.pojo.User;
import com.dream.service.impl.AgentService;

public class AgentTest {
	ApplicationContext ac=null;
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("spring/spring-bean.xml");
	}
	/**
	 * 后台申请表修改测试
	
	@Test
	public void updataAgentapply() {
		AgentRequest agentRequest= new AgentRequest();
		agentRequest.setArId(999);
		agentRequest.setArState("拒绝");
		User user =new User();
		user.setuId(2);
		agentRequest.setArResponsibility(2);
		AgentService agentService=(AgentService) ac.getBean("agentservice");
		agentService.updateAgentapply(agentRequest);
	} 
	@Test 
	public void queryallapply() {
		AgentService agentService=(AgentService) ac.getBean("agentservice");
		List<AgentRequest> list=agentService.queryallapply();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			AgentRequest agentRequest = (AgentRequest) iterator.next();
			System.out.println(agentRequest.getArState());
		}
	}
	*/
	/**
	 * 查询所有代理商操作
	
			@Test
			public void queryallagents() {
				AgentService agentService =(AgentService)ac.getBean("agentservice");
				List<Agents> list= agentService.queryallagents();
			} */
			/**
			 * 查询单个代理商信息
			
			@Test
			public void queryagents() {
				Agents agents=new Agents();
				agents.setAgId(88);
				AgentService agentService =(AgentService)ac.getBean("agentservice");
				agents= agentService.queryagents(agents);
				System.out.println(agents.getUser().getuId());
			} */
			/**
			 * app相应申请成为代理商 测试通过
			@Test
			public void insetagents() {
				AgentRequest agentRequest=new AgentRequest();
				agentRequest.setArId(999);
				agentRequest.setArState("待审核");
				agentRequest.setuId(1);
				AgentService agentService =(AgentService)ac.getBean("agentservice");
				agentService.insertagent(agentRequest);
			}
			*/
			
			/**
			 * 根据用户查询代理商信息
			
			@Test
			public void queryAgentsByUser(){
				AgentService agentService =(AgentService)ac.getBean("agentservice");
				Agents agents=new Agents();
				agents.setAgId(23);
				agents.setArea("s");
				agents.setFirstRebate(12);
				agents.setSecondRebate(14);
				agentService.updateagents(agents);;
			} */
}
