package com.dream.mapper;

import java.util.List;

import com.dream.pojo.Article;

public interface ArticleMapper {
	public void insertarticle(Article article );//新增一篇文章
	public void deletearticle(int aId);//删除某一篇文章
	public List<Article> queryallarticle();//查询所有的文章
	public List<Article> queryarticlebyid(Article article);//查询发布人的所有文章
	public  Article queryarticle(Article article);//查询某个文章内的信息
}
