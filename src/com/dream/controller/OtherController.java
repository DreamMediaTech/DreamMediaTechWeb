package com.dream.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dream.pojo.BigWithDrawals;
import com.dream.pojo.IntegralPackage;
import com.dream.service.impl.BigWithdrawalsService;
import com.dream.service.impl.RuleService;
import com.dream.util.TimeUtil;

@Controller
@RequestMapping("/otherController")
public class OtherController {

	@Autowired
	private BigWithdrawalsService bigWithdrawalsService;

	@RequestMapping("/getallwithdrawal")
	public ModelAndView getallwithdrawal(ModelAndView modelAndView ,HttpServletRequest request,HttpServletResponse response,BigWithDrawals bigWithDrawals) {
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		List<BigWithDrawals> list=bigWithdrawalsService.queryallapply();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("/withdraw.jsp");
		return modelAndView;
	}
	@RequestMapping("/updatewithdrawaly")
	public String updatewithdrawaly(ModelAndView modelAndView ,HttpServletRequest request,HttpServletResponse response,BigWithDrawals bigWithDrawals) {
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		bigWithDrawals.setBwName((String)request.getSession().getAttribute("uname"));
		bigWithDrawals.setBwRespinsibility((int) request.getSession().getAttribute("uid"));
		bigWithDrawals.setBwState("通过");
		bigWithDrawals.setBwtoTime(TimeUtil.getTimeToSecond());
		bigWithdrawalsService.updateapply(bigWithDrawals);
	
		return "redirect:/otherController/getallwithdrawal.action";
	}
	@RequestMapping("/updatewithdrawaln")
	public String updatewithdrawaln(ModelAndView modelAndView ,HttpServletRequest request,HttpServletResponse response,BigWithDrawals bigWithDrawals) {
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		bigWithDrawals.setBwName((String)request.getSession().getAttribute("uname"));
		bigWithDrawals.setBwRespinsibility((int) request.getSession().getAttribute("uid"));
		bigWithDrawals.setBwState("未通过");
		bigWithDrawals.setBwtoTime(TimeUtil.getTimeToSecond());
		bigWithdrawalsService.updateapply(bigWithDrawals);
		return "redirect:/otherController/getallwithdrawal.action";
	}
	
	@RequestMapping("/getoffwithdrawal")
	public ModelAndView getoffwithdrawal(ModelAndView modelAndView ,HttpServletRequest request,HttpServletResponse response,BigWithDrawals bigWithDrawals) {
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		List<BigWithDrawals> list=bigWithdrawalsService.queryoffapply(bigWithDrawals);
		modelAndView.addObject("list", list);
		modelAndView.setViewName("/withdraw.jsp");
		return modelAndView;
}
	@RequestMapping("/getnowithdrawal")
	public ModelAndView getnowithdrawal(ModelAndView modelAndView ,HttpServletRequest request,HttpServletResponse response,BigWithDrawals bigWithDrawals) {
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		List<BigWithDrawals> list=bigWithdrawalsService.querynoapply(bigWithDrawals);
		modelAndView.addObject("list", list);
		modelAndView.setViewName("/withdraw.jsp");
		return modelAndView;
}
	@RequestMapping("/getonwithdrawal")
	public ModelAndView getonwithdrawal(ModelAndView modelAndView ,HttpServletRequest request,HttpServletResponse response,BigWithDrawals bigWithDrawals) {
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		List<BigWithDrawals> list=bigWithdrawalsService.queryonapply(bigWithDrawals);
		modelAndView.addObject("list", list);
		modelAndView.setViewName("/withdraw.jsp");
		return modelAndView;
}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value="/uploadDisplayImage")
	@ResponseBody
	public void uploadDisplayImage(HttpServletRequest request,@RequestParam("fileToUpload") MultipartFile fileToUpload,HttpSession session,String name) throws IllegalStateException, IOException{
		if(!fileToUpload.isEmpty()){
			String path = "D:\\nginx-rtmp-win32-master\\html\\image";
			String filename = name+".jpg";
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