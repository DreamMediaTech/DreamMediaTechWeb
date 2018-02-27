package com.dream.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.mapper.Function_RoleMapper;
import com.dream.pojo.Function;
import com.dream.pojo.Role;

@Service("functionroleservice")
public class Function_RoleServiceImpl implements Function_RoleService{
	@Autowired
	private Function_RoleMapper function_RoleMapper;

	@Override
	public  List<Function> getFunctionbyRole(Role role) {
		// TODO Auto-generated method stub
		return function_RoleMapper.getFunctionbyRole(role);
	}

	@Override
	public List<Function> getFunction() {
		// TODO Auto-generated method stub
		return function_RoleMapper.getFunction();
	}

	@Override
	public List<Role> getRole() {
		// TODO Auto-generated method stub
		return function_RoleMapper.getRole();
	}

	@Override
	public int insertRole( Role role) {
		// TODO Auto-generated method stub
		function_RoleMapper.insertRole(role);
		return role.getrId();
	}



	@Override
	public void deleteRole(Role role) {
		// TODO Auto-generated method stub
		function_RoleMapper.deleteRole(role);
	}

	@Override
	public Role queryrole(Role role) {
		// TODO Auto-generated method stub
		return function_RoleMapper.queryrole(role);
	}

	@Override
	public List<Function> getunFunctionbyRole(Role role) {
		// TODO Auto-generated method stub
		return function_RoleMapper.getunFunctionbyRole(role);
	}

	

	@Override
	public void deleteFunctionbyrole(List<Integer> fid) {
		// TODO Auto-generated method stub
		function_RoleMapper.deleteFunctionbyrole(fid);
	}

	@Override
	public void updateRole(Role role) {
		// TODO Auto-generated method stub
		function_RoleMapper.updateRole(role);
	}

	@Override
	public void insertFunction(int rid, List<Integer> fid) {
		// TODO Auto-generated method stub
		function_RoleMapper.insertFunction(rid, fid);
	}




	
	


	
	

}
