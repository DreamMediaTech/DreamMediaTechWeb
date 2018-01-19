package com.dream.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.mapper.ArticleMapper;
import com.dream.pojo.Article;
@Service("articleservice")
public class ArticleServiceImpl implements ArticleService {
@Autowired
private ArticleMapper articleMapper;
/**
 * 新增一篇文章
 */
	@Override
	public void insertarticle(Article article) {
		
		// TODO Auto-generated method stub
		articleMapper.insertarticle(article);
	}
	/**
	 * 删除某一篇文章
	 */
@Override
public void deletearticle(int aId) {
	// TODO Auto-generated method stub
	articleMapper.deletearticle(aId);
	
}
/**
 * 获取所有文章
 */
	@Override
	public List<Article> queryallarticle() {
		// TODO Auto-generated method stub
		List<Article> list= articleMapper.queryallarticle();
		return list;
	}
	/**
	 * 获取某个人的所有文章
	 */
	@Override
	public List<Article> queryarticlebyid(Article article) {
		// TODO Auto-generated method stub
		List<Article> list =articleMapper.queryarticlebyid(article);
		return list;
	}
	/**
	 * 获取文章内的所有内容
	 */
	@Override
	public Article queryarticle(Article article) {
		// TODO Auto-generated method stub
		article=articleMapper.queryarticle(article);
		return article;
	}

}
