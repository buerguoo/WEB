package com.java.demo.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.demo.dao.ArticleCommentDao;
import com.java.demo.dao.ArticleDao;
import com.java.demo.dao.impl.ArticleCommentDaoImpl;
import com.java.demo.model.entity.Article;
import com.java.demo.model.entity.ArticleComment;
import com.java.demo.service.ArticleService;

@Service("ArticleService")
public  class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleDao articledao;
	
	@Override
	public void addArticle(Article article) {
		// TODO Auto-generated method stub
		articledao.insert(article);
	}

	@Override
	public List<Article> getAllArticles() {
		// TODO Auto-generated method stub
		return articledao.getAll();
	}

	@Override
	public Article getArticleById(Integer articleId) {
		// TODO Auto-generated method stub
		return articledao.search(articleId);
	}

	@Override
	public void deleteArticleById(Integer articleId) {
		// TODO Auto-generated method stub
		articledao.delete(articleId);
	}

	@Override
	public boolean updateArticleById(Article article) {
		// TODO Auto-generated method stub
		articledao.update(article);
		return true;
	}

	@Override
	public int getCommentCount(Integer articleId) {
		// TODO Auto-generated method stub
		ArticleCommentDao acd = new ArticleCommentDaoImpl();
		List<ArticleComment> comments = acd.getAllArticleComments(articleId);
		return comments.size();
	}

	@Override
	public List<Article> getArticlesByLabel(String label) {
		// TODO Auto-generated method stub
		return articledao.search(label);
	}

}
