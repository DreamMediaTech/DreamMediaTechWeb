package com.dream.mapper;

import org.apache.ibatis.annotations.Param;

import com.dream.pojo.Role;
import com.dream.pojo.User;

public interface UserMapper {
		public User queryuser(User user);//使用ymid登陆网页后台
		
		public Role getRoleById(int id);//根据角色名获得角色信息
		
		public void defineUserToRole(@Param("userid") int uid,@Param("Roleid") int rid);//给用户分配角色
		

}
