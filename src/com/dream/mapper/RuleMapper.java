package com.dream.mapper;

import java.util.List;

import com.dream.pojo.Agents;
import com.dream.pojo.Member;
import com.dream.pojo.Rule;

public interface RuleMapper {
	public List<Rule> getall();//获得所有的规则
	public void updaterule(Rule rule);//更新某个规则
	public void updatefirst(Agents agents);//更新代理商的两个值
	public void updatesecond(Agents agents);
	public void updatememberbate(Member member);//更新个人的返还比例
}
