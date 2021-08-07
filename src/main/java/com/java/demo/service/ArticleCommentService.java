package com.java.demo.service;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import com.java.demo.model.entity.ArticleComment;
import com.java.demo.model.entity.User;

public interface ArticleCommentService {
	
	// 添加
	void addArticleComment(ArticleComment articleComment);
	
	// 获得当前文章下的评论
	Collection<ArticleComment> getAllArticleComments(int articleId);
	
	// 获取单个评论
	ArticleComment getArticleCommentById(Integer commentId);
	
	// 删除评论
	void deleteArticleCommentById(int articleId);
	
	// 获取当前的最大id
	Integer getMaxCommentId();
	
	// 获取当前类型所有评论
	public List<ArticleComment> getAllArticleCommentsByType(Integer leaveId);
	
//	// 回复评论
//	void replyArticleCommentById(User user, int replyId,String content,int articleID);
//	
//	public void replyArticleCommentById(Integer artId,Integer userId, Integer replyId,String content,Timestamp posttime);
}
