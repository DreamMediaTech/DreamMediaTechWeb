package com.dream.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.mapper.RuleMapper;
import com.dream.pojo.Agents;
import com.dream.pojo.Member;
import com.dream.pojo.Rule;
@Service("ruleService")
public class RuleServiceImpl implements RuleService{
	@Autowired
	private RuleMapper ruleMapper;
	
	
	@Override
	public List<Rule> getall() {
		List<Rule> list =ruleMapper.getall();
				
		return list;
	}

	@Override
	public void updaterule(Rule rule) {
		// TODO Auto-generated method stub
		ruleMapper.updaterule(rule);
	}

	@Override
	public void updatefirst(Agents agents) {
		// TODO Auto-generated method stub
		ruleMapper.updatefirst(agents);
	}

	@Override
	public void updatesecond(Agents agents) {
		// TODO Auto-generated method stub
		ruleMapper.updatesecond(agents);
	}

	@Override
	public void updatememberbate(Member member) {
		// TODO Auto-generated method stub
		ruleMapper.updatememberbate(member);
	}



}
