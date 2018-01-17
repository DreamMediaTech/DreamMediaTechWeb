package com.dream.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.mapper.VideoMapper;
import com.dream.pojo.VideoProviderRequest;

@Service("videoservice")
public class VideoServiceImpl implements VideoService {
@Autowired
private VideoMapper videoMapper;
/**
 * 后台修改申请表
 */
	@Override
	public void updateVideoapply(VideoProviderRequest videoProviderRequest) {
		// TODO Auto-generated method stub
		videoMapper.updateVideoapply(videoProviderRequest);
	}
	/**
	 * 后台查询所有申请表
	 */
	@Override
	public List<VideoProviderRequest> queryallapply() {
		// TODO Auto-generated method stub
		List<VideoProviderRequest> list=videoMapper.queryallapply();
		return list;
	}
	/**
	 * 后台查询单个申请表
	 */
	@Override
	public VideoProviderRequest queryvideoapply(VideoProviderRequest videoProviderRequest) {
		// TODO Auto-generated method stub
		VideoProviderRequest vpr=videoMapper.queryvideoapply(videoProviderRequest);
		return vpr;
	}

}
