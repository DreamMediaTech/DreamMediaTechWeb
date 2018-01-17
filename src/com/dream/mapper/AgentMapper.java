package com.dream.mapper;

import java.util.List;

import com.dream.pojo.AgentRequest;

public interface AgentMapper {
	public List<AgentRequest> queryallapply();//后台查询所有代理商申请
	public AgentRequest queryagentapply(AgentRequest agentRequest);//查询单个代理商申请
	public void updateAgentapply(AgentRequest agentRequest);//后台修改代理商申请
}
