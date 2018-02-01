package com.dream.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.mapper.MemberMapper;
import com.dream.pojo.Member;
import com.dream.pojo.User;

@Service("memberservice")
public class MemberServiceImpl implements MemberService{
@Autowired
private MemberMapper memberMapper;

/**
 * 查询所有会员，返回list值
 */
@Override
public List<Member> queryallmember() {
	// TODO Auto-generated method stub
	List<Member> list=memberMapper.queryallmember();
	return list;
}
/**
 * 查询单个会员，返回Pojo值
 */
@Override
public Member querymember(Member member) {
	// TODO Auto-generated method stub
	//不需要获得其他值，member自动获取
	member=memberMapper.querymember(member);
	return member;
}
/**
 * 创建新会员
 */
@Override
public Member createMember(User Introducer) {
	Member member = new Member();
	member.setBonusIntegral(0);
	member.setConsumptionIntegral(0);
	member.setSharingIntegral(0);
	if(Introducer!=null){
		member.setIntroducer(Introducer.getuId());
		memberMapper.createMemberByShare(member);
	}else{
		memberMapper.createMember(member);
	}
	return member;
}
@Override
public void updateMember(Member member) {
	// TODO Auto-generated method stub
	memberMapper.updateMember(member);
	
}
@Override
public List<Member> querydimmember(String dim) {
	// TODO Auto-generated method stub
	List<Member> list =memberMapper.querydimmember(dim);
	return list;
}

 
 
}
