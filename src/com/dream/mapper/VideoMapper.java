package com.dream.mapper;

import java.util.List;

import com.dream.pojo.VideoProviderRequest;

public interface VideoMapper {
	public List<VideoProviderRequest> queryallapply();//后台查询所有申请
	public void updateVideoapply(VideoProviderRequest videoProviderRequest);//后台审核申请会员成为视频创作者
}
