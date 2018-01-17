package com.dream.test.folder;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
		videoProviderRequest.setVprRespinsibility(2);
		videoProviderRequest.setVprState("通过");
		VideoService videoService =(VideoService) ac.getBean("videoservice");
		videoService.updateVideoapply(videoProviderRequest);
	}
}
