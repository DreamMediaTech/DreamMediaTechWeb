package com.dream.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dream.pojo.Function;
import com.dream.pojo.Role;
import com.dream.pojo.User;

public interface UserMapper {
		public User queryuser(User user);//使用ymid登陆网页后台
		
		public Role getRoleById(int id);//根据角色名获得角色信息
		
		public void defineUserToRole(@Param("userid") int uid,@Param("Roleid") int rid);//给用户分配角色
		
		public void insertNewUser(User user);//创建新用户
		
		public User getUserById(int uId);//根据用户id获取用户及会员信息

		public User queryUserByPhone(String phone);//根据电话号码查询用户信息
		
		public int checkPhone(String phone);//检查电话能否注册
		
		public void updateUser(User user);//修改用户信息
		
		public void updateUserPassword(User user);//修改用户密码
		
        public List<Role> getRoleByUser(User user);//获取用户角色
		
		public List<Function> getFunctionByRole(User user);//根据用户角色获取用户权限
		
		public List<Function> getFunctionByUser(User user);//根据用户账号获取用户特定权限
		
		public int checkIntrgral(@Param("vid") int vid,@Param("uid")int uid);//判定用户是否具有足够的消费积分
		
		public void userBuyVideo(@Param("vid") int vid,@Param("uid")int uid);//用户购买视频
}
