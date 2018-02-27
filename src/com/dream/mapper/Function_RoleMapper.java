package com.dream.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dream.pojo.Function;
import com.dream.pojo.Role;

public interface Function_RoleMapper {
	public  List<Function> getFunctionbyRole(Role role);//根据角色获取权限
	public List<Function> getFunction();//获取所有权限
	public  List<Function> getunFunctionbyRole(Role role);//根据角色获取没有的权限
	public List<Role> getRole();//获取所有角色  这两个获取所有用于新增
	public void deleteRole(Role role);//删除角色
	public int insertRole(Role role);//新增角色
	public void insertFunction(@Param("rId")int  rid,@Param("fId") List<Integer> fid);//新增角色
	public Role queryrole(Role role);//获取权限内容
	public void deleteFunctionbyrole(List<Integer> fid);//删除角色的某个权限
	public void updateRole(Role role);//修改角色的内容
}
