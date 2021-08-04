package com.java.demo.service.impl;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.*;
import com.java.demo.dao.ArticleCommentDao;
import com.java.demo.dao.impl.ArticleCommentDaoImpl;
import com.java.demo.model.entity.ArticleComment;
import com.java.demo.service.ArticleCommentService;
import com.sun.glass.ui.Pixels.Format;
import com.sun.org.apache.bcel.internal.generic.NEW;

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
		int id = -1;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeString = df.format(new Date());
		ArticleComment articleComment = new ArticleComment(id,idSource,content,idReply,timeString);
	}

}
