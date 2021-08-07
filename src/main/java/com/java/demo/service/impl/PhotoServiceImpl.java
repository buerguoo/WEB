package com.java.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.demo.dao.PhotoDao;
import com.java.demo.model.entity.Photo;
import com.java.demo.service.PhotoService;

@Service("PhotoService")
public class PhotoServiceImpl implements PhotoService {

	@Autowired
	private PhotoDao photoDao;
	
	@Override
	public void addPhoto(Photo photo) {
		photoDao.insert(photo);
	}

	@Override
	public Photo getPhotoById(Integer photoId) {
		// TODO Auto-generated method stub
		return photoDao.search(photoId);
	}

	@Override
	public List<Photo> getPhotos(Integer albumId) {
		// TODO Auto-generated method stub
		return photoDao.getAll();
	}

	@Override
	public void deltePhoto(Integer photoId, Integer albumId) {
		// TODO Auto-generated method stub
		photoDao.delete(photoId);
	}

}
