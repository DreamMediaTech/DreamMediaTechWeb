package com.dream.test.folder;

import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dream.pojo.User;
import com.dream.pojo.VideoProviderRequest;
import com.dream.service.impl.VideoService;

public class VideoTest {
	ApplicationContext ac=null;
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("spring/spring-bean.xml");
	}
	/**
	 * 测试通过申请处理
	 */
	@Test
	public void updateVideoapply() {
		VideoProviderRequest videoProviderRequest=new VideoProviderRequest();
		videoProviderRequest.setVprId(180117);
		User user=new User();
		user.setuId(2);
		videoProviderRequest.setVprResponsibility(user);
		videoProviderRequest.setVprState("通过");
		VideoService videoService =(VideoService) ac.getBean("videoservice");
		videoService.updateVideoapply(videoProviderRequest);
	}
	/**
	 * 查询所有申请
	 */
	@Test 
	public void queryallapply() {
		VideoService videoService =(VideoService) ac.getBean("videoservice");
		List<VideoProviderRequest> list=videoService.queryallapply();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			VideoProviderRequest videoProviderRequest = (VideoProviderRequest) iterator.next();
			System.out.println(videoProviderRequest.getVprState());
		}
	}
	
}
