package com.java.demo.service.impl;

import java.util.Collection;

import com.java.demo.dao.ArticleCommentDao;
import com.java.demo.dao.ArticleDao;
import com.java.demo.dao.impl.ArticleCommentDaoImpl;
import com.java.demo.dao.impl.ArticleDaoImpl;
import com.java.demo.model.entity.Article;
import com.java.demo.model.entity.ArticleComment;
import com.java.demo.service.ArticleService;

public class ArticleServiceImpl implements ArticleService {

	private ArticleDao articledao = new ArticleDaoImpl();
	
	@Override
	public void addArticle(Article article) {
		// TODO Auto-generated method stub
		articledao.insert(article);
	}

	@Override
	public Collection<Article> getAllArticles() {
		// TODO Auto-generated method stub
		return articledao.getAll();
	}

	@Override
	public Article getArticleById(int articleId) {
		// TODO Auto-generated method stub
		return articledao.search(articleId);
	}

	@Override
	public void deleteArticleById(int articleId) {
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
	public int getCommentCount(int articleId) {
		// TODO Auto-generated method stub
		ArticleCommentDao acd = new ArticleCommentDaoImpl();
		Collection<ArticleComment> comments = acd.getAllArticleComments(articleId);
		return comments.size();
	}

}
