package com.dream.mapper;

import java.util.List;

import com.dream.pojo.BigWithDrawals;

public interface BigWithdrawalsMapper {
	public List<BigWithDrawals> queryallapply();//查询所有提现申请
	public void updateapply(BigWithDrawals bigWithDrawals);//修改申请
}