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


}
