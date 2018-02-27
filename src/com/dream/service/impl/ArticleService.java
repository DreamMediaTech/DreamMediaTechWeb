package com.dream.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dream.pojo.Article;

public interface ArticleService {
	public void publicarticle(Article article );//新增一篇文章
	public void deletearticle(int aId);//删除某一篇文章
	public List<Article> queryallarticle();//查询所有的文章
	public List<Article> queryarticlebyid(Article article);//查询发布人的所有文章
	public  Article queryarticle(Article article);//查询某个文章内的信息
	public void deletearticlelist(List<Integer> ids);//批量删除
	public List<Article> queryarticlebyid(int uId);//查询自己的文章
	public List<Article> getAllArticleToApp(int start, int num);//app获取文章
	public int countArticle();//计算文章总量
	public void updateArticle(Article article);//修改文章状态
	//三类查询
		public List<Article> queryno();
		public List<Article> queryoff();
		public List<Article> queryon();
}
