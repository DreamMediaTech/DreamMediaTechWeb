package com.dream.mapper;

import java.util.List;

import com.dream.pojo.Member;
import com.dream.service.impl.MemberService;

public interface MemberMapper {
	public List<Member> queryallmember();//查询所有会员的信息，返回列表
	public Member querymember(Member member);//查询单个会员的所有信息
	
}
