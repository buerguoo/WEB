package com.java.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.demo.dao.ArticleCommentDao;
import com.java.demo.model.entity.ArticleComment;
import com.java.demo.service.ArticleCommentService;
import java.util.List;

@Service("ArticleComment")
public class ArticleCommentServiceImpl implements ArticleCommentService {

	// 创建数据库操作对象
	@Autowired
	private ArticleCommentDao articlecommentdao;

	@Override
	public void addArticleComment(ArticleComment articleComment) {

		articlecommentdao.insert(articleComment);

	}

	@Override
	public List<ArticleComment> getAllArticleComments(Integer articleId) {

		return articlecommentdao.getAllArticleComments(articleId);
	}

	@Override
	public void deleteArticleCommentById(Integer articleId) {

		articlecommentdao.delete(articleId);
	}

	@Override
	public Integer getMaxCommentId() {

		return articlecommentdao.getMaxCommentId();
	}

	@Override
	public ArticleComment getArticleCommentById(Integer commentId) {

		return articlecommentdao.search(commentId);
	}

	@Override
	public List<ArticleComment> getAllArticleCommentsByType(Integer leaveId) {

		return articlecommentdao.getAllArticleCommentsByType(leaveId);
	}

	@Override
	public ArticleComment getLastArticleComment(Integer articleId) {

		List<ArticleComment> articleComments = articlecommentdao.getAllArticleComments(articleId);
		if (articleComments != null && articleComments.size() != 0)
			return articleComments.get(articleComments.size() - 1);
		else {
			return null;
		}
//		Integer max = 0;
//		for (ArticleComment articleComment : articleComments) {
//			if (articleComment.getCommentId() > max) {
//				max = articleComment.getCommentId();
//			}
//		}
//		return articlecommentdao.search(max);
	}
}
