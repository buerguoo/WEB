package com.java.demo.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.demo.dao.ArticleCommentDao;
import com.java.demo.model.entity.ArticleComment;
import com.java.demo.service.ArticleCommentService;
import com.java.demo.model.entity.*;

@Service("ArticleComment")
public class ArticleCommentServiceImpl implements ArticleCommentService {

	//创建数据库操作对象
	@Autowired
	private ArticleCommentDao articlecommentdao;
	
	@Override
	public void addArticleComment(ArticleComment articleComment) {
		// TODO Auto-generated method stub
		articlecommentdao.insert(articleComment);
		
	}

	@Override
	public Collection<ArticleComment> getAllArticleComments(int articleId) {
		// TODO Auto-generated method stub
		return articlecommentdao.getAll();
	}

	@Override
	public void deleteArticleCommentById(int articleId) {
		// TODO Auto-generated method stub
		articlecommentdao.delete(articleId);
	}

	@Override
	public void replyArticleCommentById(User user, int replyId,String content,int articleId) {
		// TODO Auto-generated method stub
		int id = -1;
		if(user.getUsername()==null)
			user.setUsername("匿名用户");
		ArticleComment articleComment = null;
		Collection<ArticleComment> articleComments = articlecommentdao.getAllArticleComments(articleId);
		for( ArticleComment ac :articleComments)
		{
			if(ac.getArtId()>id)
				id = ac.getArtId();
		}
		id = id+1;
		long t1 = System.currentTimeMillis();
		java.sql.Timestamp tp = new java.sql.Timestamp(t1);
		articleComment = new ArticleComment(id,articleId,user.getUserId(), replyId,content,tp);
		articlecommentdao.insert(articleComment);
	}


}
