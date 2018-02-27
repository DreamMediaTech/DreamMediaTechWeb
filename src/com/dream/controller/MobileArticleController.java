package com.dream.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.dream.pojo.Article;
import com.dream.service.impl.ArticleService;
import com.dream.util.AppInterfaceUtil;
import com.dream.util.TimeUtil;



@Controller
@RequestMapping("mobileArticleController")
public class MobileArticleController {
	private static final int SUCCESS_CODE=200;
	@Autowired
	private ArticleService articleService;
	
	/**
	 * app获取文章列表
	 * @param start
	 * @param num
	 * @return
	 */
	@RequestMapping(value="/getAllArticleToApp",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Map<String, Object> getAllArticleToApp(int start,int num){
		Map<String,Object> params = new  HashMap<String, Object>();
		params.put("count", articleService.countArticle());
		List<Article> list = articleService.getAllArticleToApp(start, num);
		return AppInterfaceUtil.createResult(SUCCESS_CODE, list, params);
	}
	
	
	/**
	 * 获取文章内容
	 * @param aid
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/getArticleToApp")
	public ModelAndView getArticleToApp(int aid,HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		Article article = new Article();
		article.setaId(aid);
		Article result = articleService.queryarticle(article);
		session.setAttribute("article_detail", result);
		modelAndView.setViewName("/article-detail-app.jsp");
		return modelAndView;
	}
	
	
	
}
