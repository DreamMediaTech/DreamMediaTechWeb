package com.dream.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.mapper.BigWithdrawalsMapper;
import com.dream.pojo.BigWithDrawals;
@Service("bigwithdrawalsservice")
public class BigWithdrawalsImpl implements BigWithdrawalsService {
	@Autowired
	private BigWithdrawalsMapper bigWithdrawalsMapper;
	@Override 
	/**
	 * 获取所有的提现
	 */
	public List<BigWithDrawals> queryallapply() {
		// TODO Auto-generated method stub
		List<BigWithDrawals> list =bigWithdrawalsMapper.queryallapply();
		return list;
	}
	/**
	 * 修改大额提现操作
	 */
	@Override
	public void updateapply(BigWithDrawals bigWithDrawals) {
		// TODO Auto-generated method stub
		bigWithdrawalsMapper.updateapply(bigWithDrawals);
		
	}
	/**
	 * app 提出大额提现
	 */
	@Override
	public void insertbwd(BigWithDrawals bigWithDrawals) {
		// TODO Auto-generated method stub
		bigWithdrawalsMapper.insertbwd(bigWithDrawals);
		
	}

}
