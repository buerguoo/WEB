package com.java.demo.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.demo.dao.ArticleCommentDao;
import com.java.demo.model.entity.ArticleComment;
import com.java.demo.service.ArticleCommentService;
import com.sun.jmx.snmp.Timestamp;

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
	public void replyArticleCommentById(int commentId,int artId,int userId, int replyId,String content,Timestamp posttime) {
		
		int id = -1;
		int replyId = 0;
//		if(username==null)
//			username = "匿名用户";
		ArticleComment articleComment = null;
		//读出文章对应评论
//		Collection<ArticleComment> articleComments = articlecommentdao.getAllArticleComments(articleId);
//		for( ArticleComment ac :articleComments)
//		{
//			if(ac.getFloor()>floor)
//				floor = ac.getFloor();
//		}
//		floor = floor+1;
		articleComments = articlecommentdao.getAll();
		for( ArticleComment ac:articleComments)
		{
			if(ac.getArtId()>id)
				id = ac.getArtId();
		}
		id = id+1;
		
		long t1 = System.currentTimeMillis();
		java.sql.Timestamp tp = new java.sql.Timestamp(t1);
		articleComment =new ArticleComment(commentid,artId,userId,replyId,content,posttime);
		articleComment = new ArticleComment(id,articleId,floor,replyfloor,content,username,tp);
		articlecommentdao.insert(articleComment);
	}

}
