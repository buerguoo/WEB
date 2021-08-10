package com.java.demo.service;

import java.sql.Timestamp;
import java.util.List;

import com.java.demo.model.entity.ArticleComment;
import com.java.demo.model.entity.User;

public interface ArticleCommentService {
	
	// 添加
	void addArticleComment(ArticleComment articleComment);
	
	// 获得当前文章下的评论
	List<ArticleComment> getAllArticleComments(Integer articleId);
	
	// 获取单个评论
	ArticleComment getArticleCommentById(Integer commentId);
	
	// 删除评论
	void deleteArticleCommentById(Integer articleId);
	
	// 获取当前的最大id
	Integer getMaxCommentId();
	
	// 获取当前类型所有评论
	public List<ArticleComment> getAllArticleCommentsByType(Integer leaveId);
	
	// 获取当前文章的最后一条评论
	public ArticleComment getLastArticleComment(Integer articleId);

}
