package com.dream.test.folder;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dream.pojo.Article;
import com.dream.pojo.User;
import com.dream.service.impl.ArticleService;

public class ArticleTest {
	ApplicationContext ac=null;
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("spring/spring-bean.xml");
	}
	/**
	 * 这是添加测试，通过
	 
	@Test
	public void insertarticle() {
		Article article =new Article();
		article.setAuthor(1);
		article.setaContent("很多很多很多");
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		article.setaTime(df.format(now));
		article.setaTitle("这是标题");
		article.setaId(53);
		ArticleService articleService= (ArticleService) ac.getBean("articleservice");
		articleService.insertarticle(article);
	}
	*/
	/**
	 *这是删除测试,通过
	 
	@Test
	public void deletearticle() {
		int aId=54;
		ArticleService articleService= (ArticleService) ac.getBean("articleservice");
		articleService.deletearticle(aId);
	}*/
	/**
	 * 测试查询全部 通过
	 
	@Test 
	public void queryallarticle() {
		ArticleService articleService= (ArticleService) ac.getBean("articleservice");
		articleService.queryallarticle();
	} */
	/**
	 * 查询某个人的所有文章 测试通过
	
	@Test 
	public void queryarticlebyid() {
		Article article =new Article();
		User user = new User();
		user.setuId(1);
		article.setUser(user);
		ArticleService articleService= (ArticleService) ac.getBean("articleservice");
		articleService.queryarticlebyid(article);
	} */
	/**
	 * 测试查询某个文章所有内容
	 */
	@Test public void quertarticle() {
		Article article =new Article();
		article.setaId(56);
		ArticleService articleService= (ArticleService) ac.getBean("articleservice");
		articleService.queryarticle(article);
	}
}
