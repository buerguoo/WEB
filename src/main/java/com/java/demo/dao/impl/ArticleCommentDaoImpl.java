package com.java.demo.dao.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
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

	public List<ArticleComment> getAllArticleComments(int articleid){
		
		QueryWrapper<ArticleComment> queryWrapper = Wrappers.query();
		queryWrapper.like("articleid",articleid);
		return articleCommentMapper.selectList(queryWrapper);
	}
}
