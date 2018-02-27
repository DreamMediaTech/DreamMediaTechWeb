package com.dream.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dream.pojo.Comment;
import com.dream.pojo.Video;
import com.dream.pojo.VideoProviderRequest;
import com.dream.pojo.VideoType;

public interface VideoService {
	public void insertVRP(VideoProviderRequest videoProviderRequest);//插入申请成为视频创作的请求
	public List<VideoProviderRequest> queryallapply();//后台查询所有申请
	public boolean updateVideoapply(VideoProviderRequest videoProviderRequest);//后台审核申请会员成为视频创作者
	public void uploadVideo();//后台上传视频
	public void insertVideoType(VideoType videoType);//添加视频类型
	public void updateVideoType(VideoType videoType);//修改视频类型
	public void deleteVideoType(int id);//删除视频类型
	public List<VideoType> getAllVideoType();//获取视频类型
	public void insertComment(Comment comment);//发布视频评论
	public void updateComment(Comment comment);//审核视频评论
	public void deleteComment(List<Integer> ids);//删除视频评论
	public void deleteAllUnexamineComment();//删除所有不通过审核的评论
	public List<Comment> getAllCommentByVideo(int vid);//根据视频获取该视频所有评论
	public List<Comment> getCommentByState(int state);//获取所有未审核评论
	public List<Comment> getExamineCommentByVideo(int vid);//获取视频所有通过审核的评论
	public List<Comment> getExamineCommentByVideoToAPP(int vid,int start,int num);//app限量获取已通过审核的评论
	public List<Comment> getAllComment();//获取所有视频评论
	public void insertVideoInformation(Video video);//插入视频信息
	public void addVideoScoure(Video video);//插入视频源
	public void updateVideoInformation(Video video);//修改视频信息
	public void updateVideoNum(int vid);//更新视频播放次数
	public int countVideoByType(int type);//根据类别获取视频总数
	public List<Video> getVideoList(int type, int start,int num);//根据分页以及类别获取视频列表
	public Video getVideoById(int vid);//根据视频编号获取具体视频信息
	public int userBuyVideo(int vid,int uid);//用户购买视频
	public void userStartVideo(int vid,int uid);//用户请求播放视频
	public void switchComment(List<Integer> vids);//运营方调整视频评论开关
	public List<Video> getOwnVideoList(int uid);//视频创作者查看上传视频及收益
	public int getAllProfit(int uid);//视频创作者查看视频总收益
	public List<VideoType> getAllVideoTypeToWeb();//获取所有类别
	public void insertVideoAddress(Video video);//添加视频源
	public List<Video> getAllVideo();//获取所有视频
	public List<Video> getAllVideoByState(int state);//获取所有未通过审核的视频
	public int checkUserQuota(int vid,int uid);//检测用户剩余额度
	public void auditVideo(int vid,int state);//审核视频
	public Comment getCommentById(int cid);//根据编号获取评论信息
	//三类查询
		public List<VideoProviderRequest> queryon();
		public List<VideoProviderRequest> queryoff();
		public List<VideoProviderRequest> queryno();
		//通过视频创作者申请后，更改角色为视频创作者
		public void updatevpr(@Param("uId") int uId);
}
