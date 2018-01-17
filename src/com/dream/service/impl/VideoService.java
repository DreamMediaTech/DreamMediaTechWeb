package com.dream.service.impl;

import java.util.List;

import com.dream.pojo.VideoProviderRequest;

public interface VideoService {
	public List<VideoProviderRequest> queryallapply();//后台查询所有申请
	public VideoProviderRequest queryvideoapply(VideoProviderRequest videoProviderRequest);//后台查询单个申请内的信息
	public void updateVideoapply(VideoProviderRequest videoProviderRequest);//后台审核申请会员成为视频创作者
}
