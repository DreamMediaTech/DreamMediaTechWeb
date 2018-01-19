package com.dream.service.impl;

import org.springframework.stereotype.Service;

import com.dream.mapper.StoreMapper;

@Service("storeservice")
public class StoreServiceImpl implements StoreService {
	private StoreMapper storeMapper;
}
