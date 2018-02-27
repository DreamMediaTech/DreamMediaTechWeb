package com.dream.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.dream.pojo.Article;
import com.dream.service.impl.ArticleService;
import com.dream.util.TimeUtil;



@Controller
@RequestMapping("articleController")
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	@RequestMapping("/getarticle")
	public ModelAndView getarticle(HttpServletRequest request,HttpServletResponse response) throws IOException{
		ModelAndView modelAndView=new ModelAndView();
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		List<Article> list=  articleService.queryallarticle();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("/article-list.jsp");
		return modelAndView;
	}
	@RequestMapping("/getarticlerequest")
	public ModelAndView getarticlerequest(HttpServletRequest request,HttpServletResponse response) throws IOException{
		ModelAndView modelAndView=new ModelAndView();
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		List<Article> list=  articleService.queryallarticle();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("/article-request.jsp");
		return modelAndView;
	}
	@RequestMapping("/queryarticlebyid")
	public ModelAndView queryarticlebyid(HttpServletRequest request,HttpServletResponse response,int uId) throws IOException{
		ModelAndView modelAndView=new ModelAndView();
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		List<Article>list=  articleService.queryarticlebyid(uId);
		modelAndView.addObject("list", list);
		modelAndView.setViewName("/article-mylist.jsp");
		return modelAndView;
	}
	
	@RequestMapping("/queryarticle")
	public ModelAndView queryarticle(HttpServletRequest request,HttpServletResponse response,Article article) throws IOException{
		ModelAndView modelAndView=new ModelAndView();
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		 article=  articleService.queryarticle(article);
		modelAndView.addObject("article", article);
		modelAndView.setViewName("/article-detail.jsp");
		return modelAndView;
	}
	
	@RequestMapping("/queryarticlerequest")
	public ModelAndView queryarticlerequest(HttpServletRequest request,HttpServletResponse response,Article article) throws IOException{
		ModelAndView modelAndView=new ModelAndView();
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		 article=  articleService.queryarticle(article);
		modelAndView.addObject("article", article);
		modelAndView.setViewName("/article-detailrequest.jsp");
		return modelAndView;
	}
	
	@RequestMapping("skiparticle")
	public ModelAndView skiparticle(HttpServletRequest request,HttpServletResponse response,Article article ) throws IOException{
		ModelAndView modelAndView = new ModelAndView();
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		modelAndView.setViewName("/public-article.jsp");
		
		return modelAndView;
	}
	@RequestMapping("publicarticle")
	public String publicarticle(HttpServletRequest request,HttpServletResponse response,Article article ) throws IOException{
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		article.setaTime(TimeUtil.getTimeToSecond());
		article.setuId((int)request.getSession().getAttribute("uid"));
		article.setClicks(0);
		article.setaState("待审核");
		articleService.publicarticle(article);
		return "redirect:/articleController/getarticle.action";
	}
	@RequestMapping("deletearticlelist")
	public String deletearticlelist(HttpServletRequest request,HttpServletResponse response,@RequestParam("aids") String[]  aids ) throws IOException{
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		List<Integer> ids=new ArrayList<Integer>();
		for(String id:aids){
			ids.add(Integer.parseInt(id));
		}
		articleService.deletearticlelist(ids);
		return "redirect:/articleController/getarticle.action";
	}
	
	@RequestMapping("deletearticle")
	public String deletearticle(HttpServletRequest request,HttpServletResponse response,int  aId ) throws IOException{
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		articleService.deletearticle(aId);
		return "redirect:/articleController/getarticle.action";
	}
	@RequestMapping("updateArticley")
	public String updateArticley(HttpServletRequest request,HttpServletResponse response,Article article ) throws IOException{
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		article.setaState("通过");
		article.setaSendtime(TimeUtil.getTimeToSecond());
		article.setAuId((int)request.getSession().getAttribute("uid"));
		article.setAuName((String)request.getSession().getAttribute("uname"));
		articleService.updateArticle(article);
		int a =article.getaId();
		return "redirect:/articleController/queryarticlerequest.action?aId="+a+"";
	}
	@RequestMapping("updateArticlen")
	public String updateArticlen(HttpServletRequest request,HttpServletResponse response,Article article ) throws IOException{
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		article.setaState("未通过");
		article.setAuId((int)request.getSession().getAttribute("uid"));
		article.setaSendtime(TimeUtil.getTimeToSecond());
		article.setAuName((String)request.getSession().getAttribute("uname"));
		articleService.updateArticle(article);
		int a =article.getaId();
		return "redirect:/articleController/queryarticlerequest.action?aId="+a+"";
	}
	@RequestMapping("/queryarticleon")
	public ModelAndView queryarticleon(HttpServletRequest request,HttpServletResponse response,Article article) throws IOException{
		ModelAndView modelAndView=new ModelAndView();
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		List<Article> list=  articleService.queryon();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("/article-request.jsp");
		return modelAndView;
	}
	@RequestMapping("/queryarticleno")
	public ModelAndView queryarticleno(HttpServletRequest request,HttpServletResponse response,Article article) throws IOException{
		ModelAndView modelAndView=new ModelAndView();
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		List<Article> list=  articleService.queryno();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("/article-request.jsp");
		return modelAndView;
	}
	@RequestMapping("/queryarticleoff")
	public ModelAndView queryarticleoff(HttpServletRequest request,HttpServletResponse response,Article article) throws IOException{
		ModelAndView modelAndView=new ModelAndView();
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		List<Article> list=  articleService.queryoff();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("/article-request.jsp");
		return modelAndView;
	}
}
