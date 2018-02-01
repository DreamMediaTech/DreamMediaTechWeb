package com.dream.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dream.pojo.Video;
import com.dream.pojo.VideoProviderRequest;
import com.dream.service.impl.VideoService;

@Controller
@RequestMapping("videoController")
public class VideoController {
@Autowired
private VideoService videoService;
@RequestMapping("/getapply")
	public ModelAndView getapply(HttpServletRequest request ,HttpServletResponse response,Video	 video) {
	ModelAndView modelAndView=new ModelAndView();
	request.getSession().getAttribute("ymid");
	request.getSession().getAttribute("uid");
	request.getSession().getAttribute("uname");
	List<VideoProviderRequest> list=videoService.queryallapply();
	modelAndView.addObject("list", list);
	modelAndView.setViewName("/videoprovider-apply.jsp");
	return modelAndView;
}

}
