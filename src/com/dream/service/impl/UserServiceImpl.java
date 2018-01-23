package com.dream.service.impl;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.mapper.UserMapper;
import com.dream.pojo.Member;
import com.dream.pojo.Role;
import com.dream.pojo.User;
import com.dream.util.Encoder;

@Service("userservice")
public class UserServiceImpl implements UserService{
	private static final  int DEFAULTROLE_ID = 1; 
	private static final String LOGINSTR = "ym";
	
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private MemberService memberService ;

	/**
	 * 根据登录名查询用户
	 */
	@Override
	public User queryuser(User user) {
		// TODO Auto-generated method stub
		user=userMapper.queryuser(user);
		return user;
	}

	/**
	 * 注册新用户
	 */
	@Override
	public void registerUser(String phone, String password,User Introducer) {
		//初始化会员信息
		Member member = memberService.createMember(Introducer);
		
		//创建用户信息
		User user = new User();
		user.setuPhone(phone);
		user.setuPassword(Encoder.EncoderByMd5(password));
		user.setMemberInformation(member);
		
		userMapper.insertNewUser(user);
		
		//连接默认角色
		defineRoleToUser(user.getuId(), DEFAULTROLE_ID);
		
		//更新用户信息
		user.setYmId(LOGINSTR+user.getuId());
		updateUser(user);
	}

	/**
	 * 给用户赋予角色
	 */
	public void defineRoleToUser(int uid,int rid){
		userMapper.defineUserToRole(uid, rid);
	}

	
	/**
	 * 根据角色编号获取角色信息
	 */
	@Override
	public Role getRoleById(int id) {
		return userMapper.getRoleById(id);
	}

	/**
	 * 使用手机号码进行APP登录
	 */
	@Override
	public User appLogin(String phone,String password) {
		User user = userMapper.queryUserByPhone(phone);
		if(user==null&&user.getuPassword().equals(password)){
			return user;
		}
		else return null;
	}

	@Override
	public boolean checkPhone(String phone) {
		boolean result = false;
		if(userMapper.checkPhone(phone)==0){
			result  = true;
		}
		return result;
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateUser(user);// TODO Auto-generated method stub
	}

	@Override
	public void updatePassword(User user) {
		
	}
	
}
