package com.dream.service.impl;

import java.util.List;

import com.dream.pojo.AgentRequest;

public interface AgentService {
	public List<AgentRequest> queryallapply();//后台查询所有代理商申请
	public AgentRequest queryagentapply(AgentRequest agentRequest);//查询单个代理商申请
	public void updateAgentapply(AgentRequest agentRequest);//后台修改代理商申请
}
