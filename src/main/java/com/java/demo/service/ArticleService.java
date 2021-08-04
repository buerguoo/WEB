package com.java.demo.service;

import java.util.Collection;

import com.java.demo.model.entity.Article;

public interface ArticleService {
	
	// 文章添加
	void addArticle(Article article);
	
	// 主页面的显示?
	Collection<Article> getAllArticles();
	
	// 获取某个单个的文章
	Article getArticleById(int articleId);
	
	// 文章删除
	void deleteArticleById(int articleId);
	
	// 文章更新
	boolean updateArticleById(Article article);
	
	// 评论次数增加
	void addCommentCount(int articleId, int commentCount);
	
}
