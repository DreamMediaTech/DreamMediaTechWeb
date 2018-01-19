package com.dream.service.impl;

import java.util.List;

import com.dream.pojo.VideoProviderRequest;

public interface VideoService {
	public void insertVRP(VideoProviderRequest videoProviderRequest);//插入申请成为视频创作的请求
	public List<VideoProviderRequest> queryallapply();//后台查询所有申请
	public void updateVideoapply(VideoProviderRequest videoProviderRequest);//后台审核申请会员成为视频创作者
}
