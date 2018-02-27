package com.dream.mapper;

import java.util.List;


import com.dream.pojo.BigWithDrawals;

public interface BigWithdrawalsMapper {
	public void insertbwd(BigWithDrawals bigWithDrawals);//app提出大额提现申请
	public List<BigWithDrawals> queryallapply();//查询所有提现申请
	public void updateapply(BigWithDrawals bigWithDrawals);//修改申请
	public List<BigWithDrawals> queryoffapply(BigWithDrawals bigWithDrawals);//查询未通过的
	public List<BigWithDrawals> queryonapply(BigWithDrawals bigWithDrawals);//查询通过的
	public List<BigWithDrawals> querynoapply(BigWithDrawals bigWithDrawals);//查询未处理的
}
