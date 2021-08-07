package com.java.demo.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.naming.directory.SearchControls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.java.demo.dao.LikeCollectDao;
import com.java.demo.mapper.LikeCollectMapper;
import com.java.demo.model.entity.LikeCollect;

@Repository
public class LikeCollectDaoImpl implements LikeCollectDao {

	@Autowired
	private LikeCollectMapper lcmapper; 
	@Override
	public void insert(LikeCollect entity) {
		// TODO Auto-generated method stub
		lcmapper.insert(entity);
	}

	@Override
	public LikeCollect search(Integer id) {
		// TODO Auto-generated method stub
		return lcmapper.selectById(id);
	}
	@Override
	public List<LikeCollect> searchLikeCollectlist(Integer id)
	{
		QueryWrapper<LikeCollect> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("Id", id);
		return lcmapper.selectList(queryWrapper);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		lcmapper.deleteById(id);
	}

	@Override
	public void update(LikeCollect entity) {
		// TODO Auto-generated method stub
		lcmapper.updateById(entity);
	}

	@Override
	public List<LikeCollect> getAll() {
		// TODO Auto-generated method stub
		return lcmapper.selectList(null);
	}
		
	
}
