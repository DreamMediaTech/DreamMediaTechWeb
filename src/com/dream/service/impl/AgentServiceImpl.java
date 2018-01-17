package com.dream.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.mapper.AgentMapper;
import com.dream.pojo.AgentRequest;

@Service("agentservice")
public class AgentServiceImpl implements AgentService{
 @Autowired
 private AgentMapper agentMapper;
	@Override
	public void updataAgentapply(AgentRequest agentRequest) {
		// TODO Auto-generated method stub
		agentMapper.updataAgentapply(agentRequest);
	}

}
