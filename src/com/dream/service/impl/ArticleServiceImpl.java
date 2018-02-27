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
	public void publicarticle(Article article) {
		
		// TODO Auto-generated method stub
		articleMapper.publicarticle(article);
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
	@Override
	public void deletearticlelist(List<Integer> ids) {
		// TODO Auto-generated method stub
		articleMapper.deletearticlelist(ids);
	}
	@Override
	public List<Article> queryarticlebyid(int uId) {
		// TODO Auto-generated method stub
		List<Article> list= articleMapper.queryarticlebyid(uId);
		return list;
	}
	
	/**
	 * app获取文章列表
	 */
	@Override
	public List<Article> getAllArticleToApp(int start, int num) {
		return articleMapper.getAllArticleToApp(start, num);
	}
	
	/**
	 * 计算文章总量
	 */
	@Override
	public int countArticle() {
		return articleMapper.countArticle();
	}
	@Override
	public void updateArticle(Article article) {
		// TODO Auto-generated method stub
		articleMapper.updateArticle(article);
	}
	@Override
	public List<Article> queryno() {
		// TODO Auto-generated method stub
		return articleMapper.queryno();
	}
	@Override
	public List<Article> queryoff() {
		// TODO Auto-generated method stub
		return articleMapper.queryoff();
	}
	@Override
	public List<Article> queryon() {
		// TODO Auto-generated method stub
		return articleMapper.queryon();
	}

}
