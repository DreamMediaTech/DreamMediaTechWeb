package com.dream.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.mapper.MemberMapper;
import com.dream.pojo.Member;

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
	memberMapper.addintroducer();
}


}
