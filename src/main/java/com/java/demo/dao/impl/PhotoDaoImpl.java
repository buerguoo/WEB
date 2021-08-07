package com.java.demo.dao.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.demo.dao.PhotoDao;
import com.java.demo.mapper.PhotoMapper;
import com.java.demo.model.entity.Photo;

@Repository
public class PhotoDaoImpl implements PhotoDao {

	@Autowired
	private PhotoMapper photoMapper;

	@Override
	public void insert(Photo entity) {

		photoMapper.insert(entity);

	}

	@Override
	public Photo search(Integer id) {

		return photoMapper.selectById(id);
	}

	@Override
	public void delete(Integer id) {

		photoMapper.deleteById(id);

	}

	@Override
	public void update(Photo entity) {
		
		photoMapper.updateById(entity);
	}

	@Override
	public List<Photo> getAll() {
		
		return photoMapper.selectList(null);
	}
	
}
