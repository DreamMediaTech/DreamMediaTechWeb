package com.dream.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.mapper.UserMapper;
import com.dream.mapper.VideoMapper;
import com.dream.pojo.Comment;
import com.dream.pojo.User;
import com.dream.pojo.Video;
import com.dream.pojo.VideoProviderRequest;
import com.dream.pojo.VideoPurchaseRecord;
import com.dream.pojo.VideoType;
import com.dream.util.TimeUtil;

@Service("videoService")
public class VideoServiceImpl implements VideoService {
	private static final int DEFAULT_VIDEOTYPEFATHER = 0;
	private static final int UNEXAMINE_STATE = -1;
	private static final int NOT_ENOUGH = 5;
	private static final int NOT_ENOUGH_COUNT = 5;
	private static final int ENCOUGH_COUNT = 200;
@Autowired
private VideoMapper videoMapper;
@Autowired
private UserMapper userMapper;
/**
 * 后台修改申请表
 * @return 
 */
	@Override
	public boolean updateVideoapply(VideoProviderRequest videoProviderRequest) {
		// TODO Auto-generated method stub
		videoMapper.updateVideoapply(videoProviderRequest);
		return true;
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
	 * app申请成为视频创作者
	 */
	@Override
	public void insertVRP(VideoProviderRequest videoProviderRequest) {
		// TODO Auto-generated method stub
		videoMapper.insertVRP(videoProviderRequest);
		
	}
	
	@Override
	public void uploadVideo() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 添加视频类别
	 */
	@Override
	public void insertVideoType(VideoType videoType) {
		videoMapper.insertVideoType(videoType);
	}
	
	/**
	 * 修改视频类别信息
	 */
	@Override
	public void updateVideoType(VideoType videoType) {
		videoMapper.updateVideoType(videoType);// TODO Auto-generated method stub
		
	}
	
	/**
	 * 删除视频信息
	 */
	@Override
	public void deleteVideoType(int id) {
		videoMapper.deleteVideoType(id);
	}
	
	/**
	 * 获取视频类型
	 */
	@Override
	public List<VideoType> getAllVideoType() {
		List<VideoType> list= videoMapper.getAllVideoType();
		List<VideoType> result = new ArrayList<VideoType>();
		for(VideoType videoType : list){
			if(videoType.getVtFather()==0){
				videoType.setSubTypes(new ArrayList<VideoType>());
				result.add(videoType);
			}
		}
		for(VideoType subType:list){
			if(subType.getVtFather()!=0){
				for(VideoType fatherType : result){
					if(subType.getVtFather()==fatherType.getVtId()){
						fatherType.getSubTypes().add(subType);
					}
				}
			}
		}
		return result;
	}
	
	/**
	 * 插入评论
	 */
	@Override
	public void insertComment(Comment comment) {
		User user = new User();
		user.setuId(0);
		comment.setcResponsibility(user);
		comment.setcTime(TimeUtil.getTimeToSecond());
		System.out.println(comment.getcTime());
		videoMapper.insertComment(comment);
		
	}
	
	/**
	 * 审核评论
	 */
	@Override
	public void updateComment(Comment comment) {
		videoMapper.updateComment(comment);
		videoMapper.updateCommentNum(comment.getVideo().getvId());
		
	}
	
	/**
	 * 删除评论
	 */
	@Override
	public void deleteComment(List<Integer> ids) {
		for(int id :ids){
			videoMapper.deleteComment(id);
		}

	}
	
	
	/**
	 * 删除所有未通过的评论
	 * 
	 */
	@Override
	public void deleteAllUnexamineComment() {
		videoMapper.deleteAllUnexamineComment(UNEXAMINE_STATE);// TODO Auto-generated method stub
		
	}
	

	/**
	 * 获取某视频的所有评论
	 */
	@Override
	public List<Comment> getAllCommentByVideo(int vid) {
		return videoMapper.getAllCommentByVideo(vid);
		
	}
	
	
	/**
	 * 获取某已通过审核的视频评论
	 */
	@Override
	public List<Comment> getExamineCommentByVideo(int vid) {
		return videoMapper.getExamineCommentByVideo(vid);// TODO Auto-generated method stub
		
	}
	
	/**
	 * 获取视频评论
	 */
	@Override
	public List<Comment> getAllComment() {
		return videoMapper.getAllComment();// TODO Auto-generated method stub
		
	}
	/**
	 * 插入视频信息
	 */
	@Override
	public void insertVideoInformation(Video video) {
		videoMapper.insertVideoInformation(video);
	}
	
	/**
	 * 添加视频源
	 */
	@Override
	public void addVideoScoure(Video video) {
		videoMapper.addVideoScoure(video);// TODO Auto-generated method stub
		
	}
	
	/**
	 * 进行后台视频审核
	 */
	@Override
	public void updateVideoInformation(Video video) {
		videoMapper.updateVideoInformation(video);
	}
	
	/**
	 * 根据分页获取视频列表
	 */
	@Override
	public List<Video> getVideoList(int type, int start,int num) {
		return videoMapper.getVideoByType(type,start,num);
	}
	
	/**
	 * 根据视频编号获取具体视频内容
	 */
	@Override
	public Video getVideoById(int vid) {
		return videoMapper.getVideoById(vid);
	}
	
	/**
	 * 更新视频播放次数
	 */
	@Override
	public void updateVideoNum(int vid) {
		videoMapper.updateVideoNum(vid);
	}
	


	/**
	 * 用户购买视频
	 * @param vid 视频编号
	 * @param uid 用户编号
	 * @return
	 */
	@Override
	public int userBuyVideo(int vid, int uid) {
		int r = userMapper.checkIntrgral(vid, uid);
		if(r==200){
			userMapper.userBuyVideo(vid, uid);
			VideoPurchaseRecord purchaseRecord = new VideoPurchaseRecord();
			User user = new User();
			user.setuId(uid);
			Video video = new Video();
			video.setvId(vid);
			purchaseRecord.setUser(user);
			purchaseRecord.setVideo(video);
			purchaseRecord.setTime(TimeUtil.getTimeToSecond());
			purchaseRecord.setEndTime(TimeUtil.getTomorrowTimeToSecond());
			videoMapper.insertVidoePurchaseRecode(purchaseRecord);
		}
		return r;
	}
	/**
	 * 用户观看视频
	 * @param vid 视频编号
	 * @param uid 用户编号
	 * @return
	 */
	
	@Override
	public void userStartVideo(int vid, int uid) {
		videoMapper.subUserCount(vid, uid);
		videoMapper.updateVideoNum(vid);
	}
	
	/**
	 * 改变视频评论开关
	 */
	@Override
	public void switchComment(List<Integer> vids) {
		videoMapper.swtichCommentById(vids);
	}
	
	/**
	 * app限量获取视频评论
	 */
	@Override
	public List<Comment> getExamineCommentByVideoToAPP(int vid, int start, int num) {
		return videoMapper.getExamineCommentByVideoToAPP(vid, start, num);
	}
	/**
	 * 根据类别获取视频总数
	 */
	@Override
	public int countVideoByType(int type) {
		
		return videoMapper.countVideoByType(type);
	}
	
	/**
	 * 用户查询自己上传的视频及收益
	 */
	@Override
	public List<Video> getOwnVideoList(int uid) {
		return videoMapper.getOwnVideoList(uid);
	}
	
	/**
	 * 计算用户的总收益
	 */
	@Override
	public int getAllProfit(int uid) {
		return videoMapper.getAllProfit(uid);
	}
	
	/**
	 * 获取所有类别用户上传使用
	 */
	@Override
	public List<VideoType> getAllVideoTypeToWeb() {
		return videoMapper.getAllVideoType();
	}
	
	/**
	 * 将视频源添加到数据库里
	 */
	
	@Override
	public void insertVideoAddress(Video video) {
		videoMapper.insertVideoAddress(video);
		
	}
	
	/**
	 * 获取所有 视频
	 */
	@Override
	public List<Video> getAllVideo() {
		
		return videoMapper.getAllVideo();
	}
	
	/**
	 * 根据状态查询视频列表
	 */
	@Override
	public List<Video> getAllVideoByState(int state) {
		return videoMapper.getAllVideoByState(state);
	}
	
	/**
	 * 获取用户视频观看额度
	 */
	@Override
	public int checkUserQuota(int vid, int uid) {
		return videoMapper.checkUserVideoCount(vid, uid);
	}
	
	/**
	 * 审核视频
	 */
	@Override
	public void auditVideo(int vid, int state) {
		videoMapper.auditVideo(vid, state);
	}
	
	/**
	 * 根据编号获取评论信息
	 */
	@Override
	public Comment getCommentById(int cid) {
		return videoMapper.getCommentById(cid);
	}
	
	/**
	 * 根据状态获取评论
	 */
	@Override
	public List<Comment> getCommentByState(int state) {
		return videoMapper.getCommentByState(state);
	}
	@Override
	public List<VideoProviderRequest> queryon() {
		// TODO Auto-generated method stub
		return videoMapper.queryon();
	}
	@Override
	public List<VideoProviderRequest> queryoff() {
		// TODO Auto-generated method stub
		return videoMapper.queryoff();
	}
	@Override
	public List<VideoProviderRequest> queryno() {
		// TODO Auto-generated method stub
		return videoMapper.queryno();
	}
	@Override
	public void updatevpr(int uId) {
		// TODO Auto-generated method stub
		videoMapper.updatevpr(uId);
	}
	
	


	
}
