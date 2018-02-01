package com.dream.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.dream.pojo.Article;
import com.dream.service.impl.ArticleService;



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
		List<Article>list=  articleService.queryallarticle();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("/article-list.jsp");
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
	@RequestMapping("skiparticle")
	public ModelAndView publicarticle(HttpServletRequest request,HttpServletResponse response) throws IOException{
		ModelAndView modelAndView=new ModelAndView();
		request.getSession().getAttribute("ymid");
		request.getSession().getAttribute("uid");
		request.getSession().getAttribute("uname");
		modelAndView.setViewName("/public-article.jsp");
		return modelAndView;
	}
}
