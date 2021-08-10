package com.java.demo.dao.impl;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Select;
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
	public ArticleComment search(Integer id) {
		return articleCommentMapper.selectById(id);
	}

	@Override
	public void delete(Integer id) {

		// 根据id进行删除
		articleCommentMapper.deleteById(id);
	}

	@Override
	public void update(ArticleComment entity) {

		// 更新
		articleCommentMapper.updateById(entity);
	}

	@Override
	public List<ArticleComment> getAll() {

		return articleCommentMapper.selectList(null);
	}

	@Override
	public List<ArticleComment> getAllArticleComments(Integer articleid) {

		QueryWrapper<ArticleComment> queryWrapper = Wrappers.query();
		queryWrapper.like("leaveid",0);
		queryWrapper.and(wrapper->wrapper.eq("artid",articleid));
		//queryWrapper.like("artid", articleid);
		return articleCommentMapper.selectList(queryWrapper);

	}

	@Override
	public Integer getMaxCommentId() {

		QueryWrapper<ArticleComment> queryWrapper = Wrappers.query();
		queryWrapper.select("MAX(`comment_id`) as max");
		return (Integer) articleCommentMapper.selectObjs(queryWrapper).get(0);
	}

	@Override
	public List<ArticleComment> getAllArticleCommentsByType(Integer leaveid) {
		QueryWrapper<ArticleComment> queryWrapper = Wrappers.query();
		queryWrapper.like("leaveid", leaveid);
		return articleCommentMapper.selectList(queryWrapper);
	}

}
