package com.dream.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dream.pojo.AgentRequest;
import com.dream.pojo.Agents;
import com.dream.pojo.User;

public interface AgentMapper {
	public void insertagent(AgentRequest agentRequest);//app相应请求申请成为代理商
	public List<AgentRequest> queryallapply();//后台查询所有代理商申请
	public void updateAgentapply(AgentRequest agentRequest);//后台修改代理商申请
	public List<Agents> queryallagents();//查询所有的代理商信息
	public  Agents queryagents(Agents agents);//查询某个代理商信息
	public void updateagents(Agents agents);//后台修改代理商
	public Agents queryagentsByUser(User user);//根据用户查询相应代理商信息
	public List<AgentRequest> queryoffapply(AgentRequest agentRequest);//查询未通过的
	public List<AgentRequest> queryonapply(AgentRequest agentRequest);//查询通过的
	public List<AgentRequest> querynoapply(AgentRequest agentRequest);//查询未处理的
	public int insertAgents(Agents agents);//插入新的代理商
	public Agents queryrebate();//获取标准比例
	public void insertagentsintouser( @Param("agId") int agId ,@Param ("mId") int mId);//插入新的代理商编号到user表
	public void updateRebate(Agents agents);//初始化比例
}
