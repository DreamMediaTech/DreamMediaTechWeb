package com.dream.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dream.pojo.Comment;
import com.dream.pojo.User;
import com.dream.pojo.Video;
import com.dream.pojo.VideoProviderRequest;
import com.dream.pojo.VideoType;
import com.dream.service.impl.VideoService;
import com.dream.util.AppInterfaceUtil;
import com.dream.util.Encoder_1;
import com.dream.util.TimeUtil;
import com.google.gson.Gson;
import com.sun.java.swing.plaf.motif.resources.motif;

@Controller
@RequestMapping("videoController")
public class VideoController {
	private static final String URL_HEAD="http://120.24.181.248:8090/video/";
	@Autowired
	private VideoService videoService;
	@RequestMapping("/getapply")
	public ModelAndView getapply(HttpServletRequest request ,HttpServletResponse response) {
	    ModelAndView modelAndView=new ModelAndView();
	    request.getSession().getAttribute("ymid");
	    request.getSession().getAttribute("uid");
	    request.getSession().getAttribute("uname");
	    List<VideoProviderRequest> list=videoService.queryallapply();
	    modelAndView.addObject("list", list);
	    modelAndView.setViewName("/videoprovider-apply.jsp");
	    return modelAndView;
	}
	@RequestMapping("/getnoapply")
	public ModelAndView getnoapply(HttpServletRequest request ,HttpServletResponse response) {
	    ModelAndView modelAndView=new ModelAndView();
	    request.getSession().getAttribute("ymid");
	    request.getSession().getAttribute("uid");
	    request.getSession().getAttribute("uname");
	    List<VideoProviderRequest> list=videoService.queryoff();
	    modelAndView.addObject("list", list);
	    modelAndView.setViewName("/videoprovider-apply.jsp");
	    return modelAndView;
	}
	@RequestMapping("/getoffapply")
	public ModelAndView getoffapply(HttpServletRequest request ,HttpServletResponse response) {
	    ModelAndView modelAndView=new ModelAndView();
	    request.getSession().getAttribute("ymid");
	    request.getSession().getAttribute("uid");
	    request.getSession().getAttribute("uname");
	    List<VideoProviderRequest> list=videoService.queryno();
	    modelAndView.addObject("list", list);
	    modelAndView.setViewName("/videoprovider-apply.jsp");
	    return modelAndView;
	}
	@RequestMapping("/getonapply")
	public ModelAndView getonapply(HttpServletRequest request ,HttpServletResponse response) {
	    ModelAndView modelAndView=new ModelAndView();
	    request.getSession().getAttribute("ymid");
	    request.getSession().getAttribute("uid");
	    request.getSession().getAttribute("uname");
	    List<VideoProviderRequest> list=videoService.queryon();
	    modelAndView.addObject("list", list);
	    modelAndView.setViewName("/videoprovider-apply.jsp");
	    return modelAndView;
	}
	@RequestMapping("/updatevideopay")
	public String updatevideopay(HttpServletRequest request ,HttpServletResponse response,VideoProviderRequest	 videoProviderRequest,int uId) {
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		videoProviderRequest.setVprName((String)request.getSession().getAttribute("uname"));
		videoProviderRequest.setVprState("通过");
		videoProviderRequest.setVprtoTime(TimeUtil.getTimeToSecond());
		videoProviderRequest.setVprResponsibility((int)request.getSession().getAttribute("uid"));
		if(videoService.updateVideoapply(videoProviderRequest)) {
			videoService.updatevpr(uId);
		}
		return "redirect:/videoController/getapply.action";
		}
	@RequestMapping("/updatevideopan")
	public String updatevideopan(HttpServletRequest request ,HttpServletResponse response,VideoProviderRequest	 videoProviderRequest) {
	request.getSession().getAttribute("ymid");
	request.getSession().getAttribute("uid");
	request.getSession().getAttribute("uname");
	videoProviderRequest.setVprName((String)request.getSession().getAttribute("uname"));
	videoProviderRequest.setVprState("未通过");
	videoProviderRequest.setVprtoTime(TimeUtil.getTimeToSecond());
	videoProviderRequest.setVprResponsibility((int)request.getSession().getAttribute("uid"));
	videoService.updateVideoapply(videoProviderRequest);
	return "redirect:/videoController/getapply.action";
	}


@RequestMapping(value="/getUploadPage")
public ModelAndView getUploadPage(HttpSession session){
	Gson gson  = new Gson();
	List<VideoType> list = videoService.getAllVideoTypeToWeb();
	ModelAndView modelAndView = new ModelAndView();
	session.setAttribute("typelist", gson.toJson(list));
	modelAndView.setViewName("/video-upload.jsp");
	return modelAndView;
}
	
	@RequestMapping(value="/uploadVideo")
	@ResponseBody
	public void uploadVideo(HttpServletRequest request ,@RequestParam("fileToUpload") MultipartFile fileToUpload,HttpSession session) throws IllegalStateException, IOException{
		if(!fileToUpload.isEmpty()){
		//视频源处理
			String path = "D:\\nginx-rtmp-win32-master\\html\\video";
			String filename = fileToUpload.getOriginalFilename();
		
			Video video = new Video();
			video.setvScoure(fileToUpload.getBytes());
			video.setvAddress(filename);
			videoService.insertVideoAddress(video);
			session.setAttribute("vid", video.getvId());
			System.out.println(video.getvId());
			File filepath = new File(path,filename);
			if(!filepath.getParentFile().exists()){
				filepath.getParentFile().mkdirs();
			}
		
			fileToUpload.transferTo(new File(path+File.separator+filename));
		}
	}

	@RequestMapping(value="/insertVideoInformation")
	public ModelAndView insertVideoInformation(Video video,String type,HttpSession session){
		String id =String.valueOf(session.getAttribute("vid"));
		video.setvId(Integer.parseInt(id));
		User user = new User();
		user.setuId(29);
		session.setAttribute("user", user);
		User author = (User)session.getAttribute("user");
		video.setAuthor(author);
		VideoType videoType = new VideoType();
		videoType.setVtId(Integer.parseInt(type));
		video.setFirstType(videoType);
		videoService.insertVideoInformation(video);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("getAllVideoToWeb.action");
		return modelAndView;
	}

	@RequestMapping(value="/getAllVideoToWeb")
	public ModelAndView getAllVideoToWeb(HttpServletRequest request){
		List<Video> data = videoService.getAllVideo();
		request.setAttribute("listType", "全部");
		request.setAttribute("VidoeList", data);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/video-list.jsp");
		return modelAndView;
	}

	@RequestMapping(value="/getAllVideoToWebByState")
	public ModelAndView getAllVideoToWebByState(String state,HttpServletRequest request){
		int videoState = Integer.parseInt(state);
		List<Video> data = videoService.getAllVideoByState(videoState);
		if (videoState==0) {
			request.setAttribute("listType", "未审核");
		}
		if (videoState==1) {
			request.setAttribute("listType", "已审核");
		}
		request.setAttribute("VidoeList", data);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/video-list.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/getVideoByIdToWeb")
	public ModelAndView getVideoByIdToWeb(int vid,HttpSession session){
		Video video = videoService.getVideoById(vid);
		ModelAndView modelAndView = new ModelAndView();
		if (!(video==null)){
			video.setvAddress(URL_HEAD+video.getvAddress());
			video.setvAddress_sd(URL_HEAD+video.getvAddress_sd());
			video.setvAddress_hd(URL_HEAD+video.getvAddress_hd());
			video.setvAddress_ud(URL_HEAD+video.getvAddress_ud());
			session.setAttribute("video_detail", video);
			modelAndView.setViewName("/video-detail.jsp");
		}else{
			modelAndView.setViewName("/video-list.jsp");
		}
		return modelAndView;
	}

	@RequestMapping(value="/getAllCommentToWeb")
	public ModelAndView getAllCommentToWeb(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		List<Comment> comments = videoService.getAllComment();
		request.setAttribute("CommentList", comments);
		request.setAttribute("CommentListType", "全部");
		modelAndView.setViewName("/comment-list.jsp");
		return modelAndView;
	}

	@RequestMapping(value="/getAllCommentToWebByState")
	public ModelAndView getAllCommentToWebByState(String state,HttpServletRequest request){
		int commentState = Integer.parseInt(state);
		ModelAndView modelAndView = new ModelAndView();
		List<Comment> comments = videoService.getCommentByState(commentState);
		request.setAttribute("CommentList", comments);
		switch (commentState) {
		case 1:
			request.setAttribute("CommentListType", "已审核");
					break;
		case 0:
			request.setAttribute("CommentListType", "未审核");
			break;
		default:
			break;
			}
		modelAndView.setViewName("/comment-list.jsp");
		return modelAndView;
	}

	@RequestMapping(value="/auditVideo")
	public ModelAndView auditVideo(int vid,int state){
		ModelAndView modelAndView = new ModelAndView();
		videoService.auditVideo(vid, state);
		modelAndView.setViewName("getVideoByIdToWeb.action?vid="+vid);
		return modelAndView;
	}
	
	@RequestMapping(value="/auditComment")
	public ModelAndView auditComment(int cid,int state,int vid,HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		Comment comment = new Comment();
		comment.setcId(cid);
		comment.setcState(state);
		Video video = new Video();
		video.setvId(vid);
		User user = new User();
		user.setuId(1);
//		User user = session.getAttribute("user");
		comment.setVideo(video);
		comment.setcResponsibility(user);
		videoService.updateComment(comment);
		modelAndView.setViewName("getCommentById.action?cid="+cid);
		return modelAndView;
	}
	
	@RequestMapping(value="/getCommentById")
	public ModelAndView getCommentById(int cid,HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		Comment comment = videoService.getCommentById(cid);
		request.setAttribute("Comment_detail", comment);
		modelAndView.setViewName("/comment-detail.jsp");
		return modelAndView;
	}

	
    @RequestMapping(value="/deleteAllUnexamineComment")
	public ModelAndView deleteAllUnexamineComment(){
		ModelAndView modelAndView = new ModelAndView();
		videoService.deleteAllUnexamineComment();
		modelAndView.setViewName("getAllCommentToWeb.action");
		return modelAndView;
	}
    
    @RequestMapping(value="/deleteComment")
	public ModelAndView deleteComment(Integer[] ids){
    	List<Integer> cids = Arrays.asList(ids);
		ModelAndView modelAndView = new ModelAndView();
		videoService.deleteComment(cids);
		modelAndView.setViewName("getAllCommentToWeb.action");
		return modelAndView;
	}
    
	@RequestMapping(value="/uploadVideoTypeIco")
	@ResponseBody
	public void uploadVideoTypeIco(HttpServletRequest request ,@RequestParam("fileToUpload") MultipartFile fileToUpload,int vtid,HttpSession session) throws IllegalStateException, IOException{
		if(!fileToUpload.isEmpty()){
			String path = "D:\\nginx-rtmp-win32-master\\html\\image";
			String filename = fileToUpload.getOriginalFilename();
//		
//			Video video = new Video();
//			video.setvScoure(fileToUpload.getBytes());
//			video.setvAddress(filename);
//			videoService.insertVideoAddress(video);
//			session.setAttribute("vid", video.getvId());
//			System.out.println(video.getvId());
			File filepath = new File(path,filename);
			if(!filepath.getParentFile().exists()){
				filepath.getParentFile().mkdirs();
			}
		
			fileToUpload.transferTo(new File(path+File.separator+filename));
		}
	}
}
