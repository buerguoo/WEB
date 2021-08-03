package com.java.demo.dao.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.demo.dao.ArticleCommentDao;
import com.java.demo.mapper.ArticleCommentMapper;
import com.java.demo.model.entity.ArticleComment;

@Repository
public class ArticleCommentDaoImpl implements ArticleCommentDao {

	@Autowired
	private ArticleCommentMapper articleCommentMapper;
	
	@Override
	public void insert(ArticleComment entity) {

		articleCommentMapper.insert(entity);

	}

	@Override
	public ArticleComment search(int id) {
		return articleCommentMapper.selectById(id);
	}

	@Override
	public void delete(int id) {

		// 根据id进行删除
		articleCommentMapper.deleteById(id);
	}

	@Override
	public void update(ArticleComment entity) {
		
		// 更新
		articleCommentMapper.updateById(entity);
	}

	@Override
	public Collection<ArticleComment> getAll() {
		return articleCommentMapper.selectList(null);
	}

}