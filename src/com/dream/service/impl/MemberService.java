package com.dream.service.impl;

import java.util.List;

import com.dream.pojo.Member;

public interface MemberService {
	public List<Member> queryallmember();//查询所有会员的信息，返回列表
	public Member querymember(Member member);//查询单个会员的所有信息
	
}
