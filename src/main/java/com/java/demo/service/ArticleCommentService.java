package com.java.demo.service;

import java.sql.Timestamp;
import java.util.Collection;

import com.java.demo.model.entity.ArticleComment;

public interface ArticleCommentService {
	
	// 添加
	void addArticleComment(ArticleComment articleComment);
	
	// 获得当前文章下的评论
	Collection<ArticleComment> getAllArticleComments(int articleId);
	
	// 删除评论
	void deleteArticleCommentById(int articleId);
	
	// 回复评论
	public void replyArticleCommentById(Integer artId,Integer userId, Integer replyId,String content,Timestamp posttime);
	
	//获取当前评论id最大值
	public int  getMaxCommentId();
}
