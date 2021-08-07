package com.java.demo.service;

import java.util.List;

import com.java.demo.model.entity.Article;

public interface ArticleService {
	
	// 文章添加
	void addArticle(Article article);
	
	// 主页面的显示?
	List<Article> getAllArticles();
	
	// 获取某个单个的文章
	Article getArticleById(Integer articleId);
	
	// 文章删除
	void deleteArticleById(Integer articleId);
	
	// 文章更新
	boolean updateArticleById(Article article);
	
	// 评论次数增加
	int getCommentCount(Integer articleId);

	List<Article> getArticlesByLabel(String label);
	
}
