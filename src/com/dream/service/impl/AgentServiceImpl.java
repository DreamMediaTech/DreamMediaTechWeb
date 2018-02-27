package com.dream.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.mapper.AgentMapper;
import com.dream.pojo.AgentRequest;
import com.dream.pojo.Agents;
import com.dream.pojo.User;

@Service("agentservice")
public class AgentServiceImpl implements AgentService{
 @Autowired
 private AgentMapper agentMapper;
 /**
  * 后台修改申请表
  */
	@Override
	public boolean updateAgentapply(AgentRequest agentRequest) {
		// TODO Auto-generated method stub
		agentMapper.updateAgentapply(agentRequest);
		return true;
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
	@Override
	public void updateagents(Agents agents) {
		// TODO Auto-generated method stub
		agentMapper.updateagents(agents);
	}

	/**
	 * 根据用户查询相应的代理商信息
	 */
	@Override
	public Agents queryagentsByUser(User user) {
		return agentMapper.queryagentsByUser(user);
	}
	@Override
	public List<AgentRequest> queryoffapply(AgentRequest agentRequest) {
		// TODO Auto-generated method stub
		List<AgentRequest> list =agentMapper.queryoffapply(agentRequest);
		return list;
	}
	@Override
	public List<AgentRequest> queryonapply(AgentRequest agentRequest) {
		// TODO Auto-generated method stub
		List<AgentRequest> list =agentMapper.queryonapply(agentRequest);
				return list;
	}
	@Override
	public List<AgentRequest> querynoapply(AgentRequest agentRequest) {
		// TODO Auto-generated method stub
		List<AgentRequest> list =agentMapper.querynoapply(agentRequest);
				return list;
	}
	
	@Override
	public int insertAgents(Agents agents) {
		// TODO Auto-generated method stub
		agentMapper.insertAgents(agents);
		return agents.getAgId();
	}
	@Override
	public Agents queryrebate() {
		// TODO Auto-generated method stub
		return agentMapper.queryrebate();
	}
	@Override
	public void insertagentsintouser(int agId, int mId) {
		// TODO Auto-generated method stub
		agentMapper.insertagentsintouser(agId, mId);
	}
	@Override
	public void updateRebate(Agents agents) {
		// TODO Auto-generated method stub
		agentMapper.updateRebate(agents);
	}

}
