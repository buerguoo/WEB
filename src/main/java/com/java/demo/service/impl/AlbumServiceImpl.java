package com.java.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.demo.dao.AlbumDao;
import com.java.demo.model.entity.Album;
import com.java.demo.service.AlbumService;

@Service("AlbumService")
public class AlbumServiceImpl implements AlbumService {

	@Autowired
	AlbumDao albumdao;
	@Override
	public void addAlum(Album album) {
		// TODO Auto-generated method stub
		albumdao.insert(album);
	}

	@Override
	public List<Album> getAllAlbum() {
		// TODO Auto-generated method stub
		List<Album> albums = albumdao.getAll();
		return albums;
	}

	@Override
	public Album getAlbumById(Integer albumId) {
		// TODO Auto-generated method stub
		return albumdao.search(albumId);
		
	}

	@Override
	public void deleteAlumById(Integer albumId) {
		// TODO Auto-generated method stub
		albumdao.delete(albumId);
	}

	@Override
	public Album updateAlumNameById(Integer albumId, String newName) {
		// TODO Auto-generated method stub
		Album album = albumdao.search(albumId);
		album.setName(newName);
		albumdao.update(album);
		return album;
	}

}
