package com.dream.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.mapper.AgentMapper;
import com.dream.pojo.AgentRequest;
import com.dream.pojo.Agents;

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
	 * 后台查询所有代理商
	 */
	@Override
	public List<Agents> queryallagents() {
		// TODO Auto-generated method stub
		List<Agents> list = agentMapper.queryallagents();
		return list;
	}
	/**
	 * 查询单个代理商信息
	 */
	@Override
	public Agents queryagents(Agents agents) {
		// TODO Auto-generated method stub
		agents= agentMapper.queryagents(agents);
		return agents;
	}
	/**
	 * app相应申请成为代理商业
	 */
	@Override
	public void insertagent(AgentRequest agentRequest) {
		// TODO Auto-generated method stub
		agentMapper.insertagent(agentRequest);
		
	}


}
