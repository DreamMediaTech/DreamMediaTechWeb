package com.dream.service.impl;

import com.dream.pojo.Role;
import com.dream.pojo.User;

public interface UserService {
	public User queryuser(User user);//使用ymid登陆网页后台
	
	public void registerUser(String phone, String password); //新用户注册
	
	public void defineRoleToUser(int uid,int rid);//给用户分配角色
	
	public Role getRoleById(int Id);//根据名称获取角色 
}
