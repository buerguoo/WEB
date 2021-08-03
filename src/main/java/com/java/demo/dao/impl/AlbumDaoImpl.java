package com.java.demo.dao.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.demo.dao.AlbumDao;
import com.java.demo.mapper.AlbumMapper;
import com.java.demo.model.entity.Album;

@Repository
public class AlbumDaoImpl implements AlbumDao {

	@Autowired
	private AlbumMapper albumMapper;
	
	@Override
	public void insert(Album entity) {
	albumMapper.insert(entity);
	}

	@Override
	public Album search(int id) {
		// 根据id进行查找
		return albumMapper.selectById(id);
	}

	@Override
	public void delete(int id) {

		// 根据id进行删除
		albumMapper.deleteById(id);
	}

	@Override
	public void update(Album entity) {
		
		// 更新
		albumMapper.updateById(entity);
	}

	@Override
	public Collection<Album> getAll() {
		return albumMapper.selectList(null);
	}

}
