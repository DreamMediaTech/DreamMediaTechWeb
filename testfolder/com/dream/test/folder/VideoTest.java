package com.dream.test.folder;

import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dream.pojo.AgentRequest;
import com.dream.pojo.Comment;
import com.dream.pojo.User;
import com.dream.pojo.Video;
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
	
	@Test
	public void updateVideoapply() {
		VideoProviderRequest videoProviderRequest=new VideoProviderRequest();
		videoProviderRequest.setVprId(999);
		User user=new User();
		user.setuId(2);
		videoProviderRequest.setVprResponsibility(user);
		videoProviderRequest.setVprState("通过");
		VideoService videoService =(VideoService) ac.getBean("videoservice");
		videoService.updateVideoapply(videoProviderRequest);
	} */
	/**
	 * 查询所有申请
	 */
//	@Test 
//	public void queryallapply() {
//		VideoService videoService =(VideoService) ac.getBean("videoService");
//		List<VideoProviderRequest> list=videoService.queryallapply();
//		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
//			VideoProviderRequest videoProviderRequest = (VideoProviderRequest) iterator.next();
//			System.out.println(videoProviderRequest.getVprState());
//		}
//	}
	/**
	 * app请求成为视频创作者 ,测试通过
	 
	@Test
	public void insertVPR() {
		VideoProviderRequest videoProviderRequest =new VideoProviderRequest();
		videoProviderRequest.setuId(1);
		videoProviderRequest.setVprId(999);
		videoProviderRequest.setVprState("待审核");
		VideoService videoService =(VideoService) ac.getBean("videoservice");
		videoService.insertVRP(videoProviderRequest);
	}*/
	/**
	 * 插入视频分类申请 测试通过
	 */
//	@Test
//	public void insertVideoType(){
//		VideoService videoService =(VideoService) ac.getBean("videoService");
//		VideoType videoType = new VideoType();
//		videoType.setVtName("初中语文");
//		videoType.setVtFather(4);
//		videoService.insertVideoType(videoType);
//	}
//	
	/**
	 * 更新视频类别 测试通过
	 */
//	@Test
//	public void updataVideoTypeTest(){
//		VideoService videoService =(VideoService) ac.getBean("videoService");
//		VideoType videoType = new VideoType();
//		videoType.setVtName("语文");
//		videoType.setVtFather(1);
//		videoType.setVtId(2);
//		videoService.updateVideoType(videoType);
//	}
//	
//	/**
//	 * 删除视频类别 测试通过
//	 */
//	@Test
//	public void deleteVideoTypeTest(){
//		VideoService videoService =(VideoService) ac.getBean("videoService");
//		videoService.deleteVideoType(5);
//	}
//	
//	/**
//	 * 获取视频类别  测试通过
//	 */
//	@Test
//	public void getAllVideoType(){
//		VideoService videoService =(VideoService) ac.getBean("videoService");
//		List<VideoType> list = videoService.getAllVideoType();
//		VideoType t =list.get(1);
//		t.getVtFather();
//		System.out.println(list.size());
//	}
//	
//	/**
//	 * 发布视频评论，测试通过
//	 */
	@Test
	public void insertCommentTest(){
		VideoService videoService =(VideoService) ac.getBean("videoService");
		Comment comment = new Comment();
		comment.setcContent("你好");
		User user = new User();
		user.setuId(1);
		comment.setcUser(user);
		Video video = new Video();
		comment.setVideo(video);
		for(int j=2;j<28;j++){
			comment.getVideo().setvId(j);
			for(int i=0;i<10;i++){
				videoService.insertComment(comment);
			}
		}
	}
	
	/**
	 * 审核评论
	 */
//	@Test
//	public void updateCommentTest(){
//		VideoService videoService =(VideoService) ac.getBean("videoService");
//		Comment comment = new Comment();
//		Video video = new Video();
//		video.setvId(1);
//		comment.setVideo(video);
//		comment.setcId(1);
//		User responsibility = new User();
//		responsibility.setuId(1);
//		comment.setcResponsibility(responsibility);
//		comment.setcState(1);
//		videoService.updateComment(comment);
//	}
	
	/**
	 * 删除评论 
	 */
//	@Test
//	public void deleteCommentTest(){
//		VideoService videoService =(VideoService) ac.getBean("videoService");
//		videoService.deleteComment(5);
//	}
	
	/**
	 * 删除审核不通过的所有评论
	 */
//	@Test
//	public void deleteAllUnexamineComment(){
//		VideoService videoService =(VideoService) ac.getBean("videoService");
//		videoService.deleteAllUnexamineComment();
//	}
	
	/**
	 * 获取某视频的评论
	 */
	
//	@Test
//	public void getAllCommentByVideo(){
//		VideoService videoService =(VideoService) ac.getBean("videoService");
//		videoService.getAllCommentByVideo(0);
//	}

	/**
	 * 获取所有评论
	 */
//	@Test
//	public void getAllComment(){
//		VideoService videoService =(VideoService) ac.getBean("videoService");
//		videoService.getAllComment();
//	}
	/**
	 * 获取所有通过审核的评论
	 */
//	@Test
//	public void getExamineCommentByVideoTest(){
//		VideoService videoService =(VideoService) ac.getBean("videoService");
//		videoService.getExamineCommentByVideo(0);
//	}
	/**
	 * 获取所有不通过审核的评论
	 */
//	@Test
//	public void getUnexamineComment(){
//		VideoService videoService =(VideoService) ac.getBean("videoService");
//		videoService.getUnexamineComment();
//	}
	
	/**
	 * 根据分页获取视频列表 测试通过
	 */
//	@Test
//	public void getVideoList(){
//		VideoService videoService =(VideoService) ac.getBean("videoService");
//		videoService.getVideoList(6, 1,10);
//	}
	
//	/**
//	 * 获取视频具体信息  测试通过
//	 */
	@Test
	public void getVidoe(){
		VideoService videoService =(VideoService) ac.getBean("videoService");
		videoService.getVideoById(10);
	}
	
	/**
	 * 获取类别下的视频总量
	 */
//	@Test
//	public void countVideoCount(){
//		VideoService videoService =(VideoService) ac.getBean("videoService");
//		videoService.countVideoByType(6);
//	}
	
//	/**
//	 * 更新视频播放量
//	 */
//	@Test
//	public void updateVideoNum(){
//		VideoService videoService =(VideoService) ac.getBean("videoService");
//		videoService.updateVideoNum(6);
//	}
//	
//	/**
//	 * 更新视频评论数
//	 */
//	@Test
//	public void updateVideoCommentCount(){
//		VideoService videoService =(VideoService) ac.getBean("videoService");
//		videoService.updateVideoCommentCount(6);
//	}
	
	/**
	 * 用户购买视频 测试通过
	 */
	
//	@Test
//	public void UserbyVidoe(){
//		VideoService videoService =(VideoService) ac.getBean("videoService");
//		videoService.userBuyVideo(1, 29);
//	}
	
//	@Test
//	public void UserStartVideo(){
//		VideoService videoService =(VideoService) ac.getBean("videoService");
//		int r = videoService.userStartVideo(1, 29);
//		System.out.println(r);
//	}
	
//	@Test
//	public void switchVideoById(){
//		VideoService videoService =(VideoService) ac.getBean("videoService");
//		List<Integer> vids =new ArrayList<Integer>();
//		for(int i=1;i<9;i++){
//			vids.add(i);
//		}
//		videoService.switchComment(vids);
//	}
	
	/**
	 * 获取用户具体收益列表
	 */
//	@Test
//	public void getOwnVideoList(){
//		VideoService videoService =(VideoService) ac.getBean("videoService");
//		videoService.getOwnVideoList(29);
//	}
//	
//	/**
//	 * 获取用户的总收益
//	 */
//	@Test
//	public void getAllProfit(){
//		VideoService videoService =(VideoService) ac.getBean("videoService");
//		videoService.getAllProfit(29);
//	}
//	
//	@Test
//	public void getCommentToApp(){
//		VideoService videoService =(VideoService) ac.getBean("videoService");
//		List<Comment> comments = videoService.getExamineCommentByVideoToAPP(1, 1, 9);
//		System.out.println(comments.size());
//	}
	
	/**
	 * 添加视频信息
	 */
//	@Test
//	public void insertVideoInformation(){
//		Video video = new Video();
//		video.setvId(39);
//		video.setvTitle("测试");
//		video.setvPrice(3);
//		video.setvIntroduce("测试");
//		VideoService videoService =(VideoService) ac.getBean("videoService");
//		videoService.insertVideoInformation(video);
//	}
	
//	@Test
//	public void getAllVideo(){
//		VideoService videoService =(VideoService) ac.getBean("videoService");
//		videoService.getAllVideo();
//	}
//	
	@Test
	public void getAllVideoByState(){
		VideoService videoService =(VideoService) ac.getBean("videoService");
		videoService.getAllVideoByState(1);
	}
}
