package com.dream.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dream.pojo.Comment;
import com.dream.pojo.User;
import com.dream.pojo.Video;
import com.dream.pojo.VideoType;
import com.dream.service.impl.VideoService;
import com.dream.util.AppInterfaceUtil;
import com.sun.net.httpserver.Authenticator.Success;

@Controller
@RequestMapping("/mobileVideoController")
public class MobileVideoController {
	private static final int SUCCESS_CODE = 200;
	private static final int DATA_NOT_FOUND = 3;
	private static final String URL_HEAD="http://120.24.181.248:8090/video/";
	
	
	@Autowired
	private VideoService videoService;
	
	
	/**
	 * 获取所有的视频分类
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/getAllVideoType",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Map<String, Object> getAllVideoType(HttpServletRequest request , HttpServletResponse response){
		return AppInterfaceUtil.createResult(SUCCESS_CODE, videoService.getAllVideoType(),null);
	}
	

	/**
	 * 根据视频分类限量获取视频列表
	 * @param type 视频类别
	 * @param start 开始编号
	 * @param num 获取数量
	 * @return
	 */
	@RequestMapping(value="/getAllVideoByType",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Map<String,Object> getVideoByType(int type ,int start,int num){
		int count = videoService.countVideoByType(type);
		List<Video> videos = videoService.getVideoList(type, start, num);
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("count", count);
		return AppInterfaceUtil.createResult(SUCCESS_CODE, videos,params);
	}
	
	/**
	 * 用户根据id获取视频详细信息
	 * @param vid 视频编号
	 * @param uid 用户编号
	 * @return
	 */
	
	@RequestMapping(value="/getVideoById",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Map<String,Object> getVideoById(int vid){
		Video video = videoService.getVideoById(vid);
		if (video==null) {
			return AppInterfaceUtil.createResult(DATA_NOT_FOUND, null, null);
		}else{
			video.setvAddress(URL_HEAD+video.getvAddress());
			video.setvAddress_sd(URL_HEAD+video.getvAddress_sd());
			video.setvAddress_hd(URL_HEAD+video.getvAddress_hd());
			video.setvAddress_ud(URL_HEAD+video.getvAddress_ud());
			return AppInterfaceUtil.createResult(SUCCESS_CODE, video, null);
		}
	}
	/**
	 * 用户购买视频
	 * @param vid 视频编号
	 * @param uid 用户编号
	 * @return
	 */
	@RequestMapping(value="/buyVideo",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Map<String, Object> buyVideo(int vid,int uid){
		int r = videoService.userBuyVideo(vid, uid);
		return AppInterfaceUtil.createResult(r, null, null);
	}
	
	/**
	 * 用户播放视频
	 * @param vid 视频编号
	 * @param uid 用户编号
	 * @return
	 */
	@RequestMapping(value="/userStartVideo",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Map<String, Object> userStartVideo(int vid,int uid){
		videoService.userStartVideo(vid, uid);
		return AppInterfaceUtil.createResult(200, null, null);
	}
	
	/**
	 * 视频创作者获取收益信息
	 * @param uid 视频创作者编号
	 * @return
	 */
	@RequestMapping(value="/getOwnVideoAndProfit",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Map<String,Object> getOwnVideoAndProfit(int uid){
		List<Video> list = videoService.getOwnVideoList(uid);
		int profit = videoService.getAllProfit(uid);
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("allprofit", profit);
		return AppInterfaceUtil.createResult(SUCCESS_CODE, list, params);
	}
	
	/**
	 * 用户发布评论
	 * @param vid 视频信息
	 * @param content 评论内容
	 * @param session 
	 * @return
	 */
	@RequestMapping(value="/insertComment",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Map<String,Object> insertComment(int vid ,int uid,String content){
		Comment comment = new Comment();
		comment.setcContent(content);
		User user = new User();
		user.setuId(uid);
		Video video = new Video();
		video.setvId(vid);
		comment.setcUser(user);
		comment.setVideo(video);
		videoService.insertComment(comment);
		return AppInterfaceUtil.createResult(SUCCESS_CODE,null,null);
	}
	
	/**
	 * 检查用户视频额度
	 * @param vid 视频编号
	 * @param uid 用户编号
	 * @return
	 */
	@RequestMapping(value="/getUserVideoQuota",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Map<String,Object> getUserVideoQuota(int vid ,int uid){
		return AppInterfaceUtil.createResult(SUCCESS_CODE,videoService.checkUserQuota(vid, uid),null);
	}
	
	/**
	 * 请求视频的评论
	 * @param vid 视频评论列表
	 * @param start 开始编号
	 * @param num 请求数量
	 * @return
	 */
	@RequestMapping(value="/getCommentToApp",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Map<String,Object> getCommentToApp(int vid,int start,int num){
		List<Comment> data = videoService.getExamineCommentByVideoToAPP(vid, start, num);
		return AppInterfaceUtil.createResult(SUCCESS_CODE, data, null);
	}
}