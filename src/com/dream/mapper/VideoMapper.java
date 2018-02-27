package com.dream.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dream.pojo.Comment;
import com.dream.pojo.Video;
import com.dream.pojo.VideoProviderRequest;
import com.dream.pojo.VideoPurchaseRecord;
import com.dream.pojo.VideoType;

public interface VideoMapper {
	public void insertVRP(VideoProviderRequest videoProviderRequest);//插入申请成为视频创作的请求
	public List<VideoProviderRequest> queryallapply();//后台查询所有申请
	public void updateVideoapply(VideoProviderRequest videoProviderRequest);//后台审核申请会员成为视频创作者
	public void insertVideoType(VideoType videoType);//添加视频类型
	public void updateVideoType(VideoType videoType);//修改视频类型
	public void deleteVideoType(int id);//删除视频类型
	public List<VideoType> getAllVideoType();//获取视频类别
	public void insertComment(Comment comment);//发布视频评论
	public void updateComment(Comment comment);//审核视频评论
	public void deleteComment(int Cid);//删除视频评论
	public void deleteAllUnexamineComment(int state);//删除所有不通过审核的评论
	public List<Comment> getAllCommentByVideo(int vid);//根据视频获取该视频所有评论
	public List<Comment> getCommentByState(int state);//根据状态类型获取评论
	public List<Comment> getExamineCommentByVideo(int vid);//获取视频所有通过审核的评论
	public List<Comment> getExamineCommentByVideoToAPP(@Param("vid")int vid,@Param("start")int start,@Param("num")int num);
	public List<Comment> getAllComment();//获取所有视频
	public void insertVideoInformation(Video video);//插入视频信息
	public void addVideoScoure(Video video);//插入视频源
	public void updateVideoInformation(Video video);//修改视频信息
	public List<Video> getVideoByType(@Param("type")int type,@Param("start")int start,@Param("num")int num);//根据类别获取视频列表
	public int countVideoByType(int type);//计算当前类别的视频总数
	public Video getVideoById(int id);//根据编号获取视频信息
	public void updateCommentNum(@Param("vid") int vid );//更新视频评论数
	public void updateVideoNum(int vid);//更新视频播放次数
	public void insertVidoePurchaseRecode(VideoPurchaseRecord purchaseRecord);//添加视频购买记录
	public int checkUserVideoCount(@Param("vid") int vid,@Param("uid")int uid);//检查用户是否具有视频观看额度
	public void subUserCount(@Param("vid") int vid,@Param("uid")int uid);//减少相应用户的视频额度
	public void swtichCommentById(List<Integer> vids);//根据视频编号关闭相应视频的评论功能
	public List<Video> getOwnVideoList(int uid);//视频创作者查看上传视频及收益
	public int getAllProfit(int uid);//视频创作者查看视频总收益
	public void insertVideoAddress(Video video);//视频源添加到数据库
	public List<Video> getAllVideo();//查看所有视频
	public List<Video> getAllVideoByState(int state);//根据状态查看视频
	public void auditVideo(@Param("vid") int vid,@Param("state") int state);//审核视频
	public Comment getCommentById(int cid);//获取评论内容
	//三类查询
	public List<VideoProviderRequest> queryon();
	public List<VideoProviderRequest> queryoff();
	public List<VideoProviderRequest> queryno();
	//通过视频创作者申请后，更改角色为视频创作者
	public void updatevpr(@Param("uId") int uId);
}
