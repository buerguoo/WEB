package com.java.demo.dao;

import java.util.List;

import com.java.demo.model.entity.ArticleComment;

public interface ArticleCommentDao extends Basedao<ArticleComment>{
	
	public List<ArticleComment> getAllArticleComments(int articleid);
	
}
