package com.dream.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.mapper.VideoMapper;
import com.dream.pojo.VideoProviderRequest;

@Service("videoservice")
public class VideoServiceImpl implements VideoService {
@Autowired
private VideoMapper videoMapper;
	@Override
	public void updateVideoapply(VideoProviderRequest videoProviderRequest) {
		// TODO Auto-generated method stub
		videoMapper.updateVideoapply(videoProviderRequest);
	}

}
