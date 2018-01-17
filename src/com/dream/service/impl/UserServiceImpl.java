package com.dream.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.mapper.UserMapper;
import com.dream.pojo.User;

@Service("userservice")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;

	@Override
	public User queryuser(User user) {
		// TODO Auto-generated method stub
		user=userMapper.queryuser(user);
		return user;
	}

}
