package com.dream.test.folder;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dream.pojo.AgentRequest;
import com.dream.service.impl.AgentService;

public class AgentTest {
	ApplicationContext ac=null;
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("spring/spring-bean.xml");
	}
	/**
	 * 后台申请表修改测试
	 */
	@Test
	public void updataAgentapply() {
		AgentRequest agentRequest= new AgentRequest();
		agentRequest.setArId(180117);
		agentRequest.setArState("拒绝");
		agentRequest.setArResponsibility(2);
		AgentService agentService=(AgentService) ac.getBean("agentservice");
		agentService.updateAgentapply(agentRequest);
	}
	
}
