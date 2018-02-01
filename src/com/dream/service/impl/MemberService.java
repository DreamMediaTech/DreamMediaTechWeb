package com.dream.service.impl;

import java.util.List;



import com.dream.pojo.Member;
import com.dream.pojo.User;

public interface MemberService {
	public List<Member> queryallmember();//查询所有会员的信息，返回列表
	public Member querymember(Member member);//查询单个会员的所有信息
	public Member createMember(User Introducer);//创建新会员信息
	public void updateMember(Member member);//后台修改会员信息
	public List<Member> querydimmember(String dim );//通过id或姓名模糊查询会员
}