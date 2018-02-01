package com.dream.service.impl;

import java.util.List;

import com.dream.pojo.AgentRequest;
import com.dream.pojo.Agents;

public interface AgentService {
	public void insertagent(AgentRequest agentRequest);//app相应请求申请成为代理商
	public List<AgentRequest> queryallapply();//后台查询所有代理商申请
	public void updateAgentapply(AgentRequest agentRequest);//后台修改代理商申请
	public List<Agents> queryallagents();//查询所有的代理商信息
	public  Agents queryagents(Agents agents);//查询某个代理商信息
	public void updateagents(Agents agents);//后台修改代理商
}
