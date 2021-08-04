package com.java.demo.service.impl;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.*;
import com.java.demo.dao.ArticleCommentDao;
import com.java.demo.dao.impl.ArticleCommentDaoImpl;
import com.java.demo.model.entity.ArticleComment;
import com.java.demo.service.ArticleCommentService;

public class ArticleCommentServiceImpl implements ArticleCommentService {

	//创建数据库操作对象
	private ArticleCommentDao articlecommentdao = new ArticleCommentDaoImpl();
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
	public void replyArticleCommentById(int idSource, int idReply,String content) {
		// TODO Auto-generated method stub
		int floor = -1;
		String nikename = "匿名用户";
		int acticleId = -1;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeString = df.format(new Date());
		ArticleComment articleComment = new ArticleComment(floor,idReply,nikename,acticleId,content,timeString);
		articlecommentdao.insert(articleComment);
	}

}
