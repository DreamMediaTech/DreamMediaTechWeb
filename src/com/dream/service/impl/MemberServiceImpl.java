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
 * 当有介绍人时，对介绍人进行积分添加
 */

@Override
public void addintroducer() {
	// TODO Auto-generated method stub
	
}


}
