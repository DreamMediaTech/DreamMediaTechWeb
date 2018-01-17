package com.dream.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.mapper.AgentMapper;
import com.dream.pojo.AgentRequest;

@Service("agentservice")
public class AgentServiceImpl implements AgentService{
 @Autowired
 private AgentMapper agentMapper;
 /**
  * 后台修改申请表
  */
	@Override
	public void updateAgentapply(AgentRequest agentRequest) {
		// TODO Auto-generated method stub
		agentMapper.updateAgentapply(agentRequest);
	}
	/**
	 * 后台查询所有申请表
	 */
	@Override
	public List<AgentRequest> queryallapply() {
		// TODO Auto-generated method stub
		List<AgentRequest> list=agentMapper.queryallapply();
		return list;
	}
	/**
	 * 后台查询单个申请表
	 */
	@Override
	public AgentRequest queryagentapply(AgentRequest agentRequest) {
		// TODO Auto-generated method stub
		agentRequest=agentMapper.queryagentapply(agentRequest);
		return agentRequest;
	}

}
