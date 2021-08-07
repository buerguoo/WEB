/**
 * 
 */
package com.java.demo.dao.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.java.demo.dao.ArticleDao;
import com.java.demo.mapper.ArticleMapper;
import com.java.demo.model.entity.Article;

@Repository
public class ArticleDaoImpl implements ArticleDao {


	@Autowired
	private ArticleMapper articleMapper;
	

	@Override
	public List<Article> getAll() {
		
		return articleMapper.selectList(null);
	}

	@Override
	public void insert(Article entity) {
		
		articleMapper.insert(entity);
		
	}

	@Override
	public Article search(int id) {
		
		return articleMapper.selectById(id);
	}

	@Override
	public void update(Article entity) {
		// TODO Auto-generated method stub
		articleMapper.updateById(entity);
	}

	@Override
	public void delete(int id) {
		
		articleMapper.deleteById(id);
		
	}

	@Override
	public List<Article> search(String label) {
		// TODO Auto-generated method stub
		QueryWrapper<Article> qw = new QueryWrapper<Article>();
		qw.eq("label", label);
		return articleMapper.selectList(qw);
	}

}
