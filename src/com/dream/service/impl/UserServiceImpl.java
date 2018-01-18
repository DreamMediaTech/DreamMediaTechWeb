package com.dream.service.impl;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.mapper.UserMapper;
import com.dream.pojo.Role;
import com.dream.pojo.User;
import com.dream.util.Encoder;

@Service("userservice")
public class UserServiceImpl implements UserService{
	private static final  int DEFAULTROLE_ID = 1; 
	
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User queryuser(User user) {
		// TODO Auto-generated method stub
		user=userMapper.queryuser(user);
		return user;
	}

	@Override
	public void registerUser(String phone, String password) {
		//创建用户信息
		User user = new User();
		user.setuPhone(phone);
		user.setuPassword(Encoder.EncoderByMd5(password));
		//连接默认角色
		defineRoleToUser(user.getuId(), DEFAULTROLE_ID);
	}

	public void defineRoleToUser(int uid,int rid){
		userMapper.defineUserToRole(uid, rid);
	}

	@Override
	public Role getRoleById(int id) {
		return userMapper.getRoleById(id);
	}
	

}
