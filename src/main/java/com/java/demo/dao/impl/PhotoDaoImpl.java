package com.java.demo.dao.impl;

import java.util.Collection;

<<<<<<< HEAD
=======
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> dev
import org.springframework.stereotype.Repository;

import com.java.demo.dao.PhotoDao;
import com.java.demo.mapper.PhotoMapper;
import com.java.demo.model.entity.Photo;

@Repository
public class PhotoDaoImpl implements PhotoDao {

<<<<<<< HEAD
	
=======
	@Autowired
	private PhotoMapper photoMapper;

>>>>>>> dev
	@Override
	public void insert(Photo entity) {

		photoMapper.insert(entity);

	}

	@Override
	public Photo search(int id) {

		return photoMapper.selectById(id);
	}

	@Override
	public void delete(int id) {

		photoMapper.deleteById(id);

	}

	@Override
	public void update(Photo entity) {
		photoMapper.updateById(entity);
	}

	@Override
	public Collection<Photo> getAll() {
		return photoMapper.selectList(null);
	}

}
