package com.java.demo.service;

import java.util.Collection;

import com.java.demo.model.entity.ArticleComment;
import com.java.demo.model.entity.User;

public interface ArticleCommentService {
	
	// 添加
	void addArticleComment(ArticleComment articleComment);
	
	// 获得当前文章下的评论
	Collection<ArticleComment> getAllArticleComments(int articleId);
	
	// 删除评论
	void deleteArticleCommentById(int articleId);
	
	// 回复评论
	void replyArticleCommentById(User user, int replyId,String content,int articleID);
	
}
