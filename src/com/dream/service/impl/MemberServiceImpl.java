package com.dream.service.impl;

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
 * 为分享注册人添加注册积分
 */

@Override
public void addintroducer() {
	// TODO Auto-generated method stub
	User user =new User();
	Member member=new Member();
	user.setuId("2018test");
	
	memberMapper.addintroducer();
	
}


}
