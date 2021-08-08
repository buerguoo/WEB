package com.java.demo.dao;

import java.util.List;

import com.java.demo.model.entity.Article;

public interface ArticleDao extends Basedao<Article>{

	List<Article> search(String label);
	
	// 获取当前最大的articleId
	public Integer getMaxArticleId();


	List<Article> fuzzysearchByName(String str);

	
}
