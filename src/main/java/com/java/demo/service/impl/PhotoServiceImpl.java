package com.java.demo.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.demo.dao.PhotoDao;
import com.java.demo.model.entity.Photo;
import com.java.demo.service.PhotoService;
@Service
public class PhotoServiceImpl implements PhotoService {

	@Autowired
	private PhotoDao photoDao;
	
	@Override
	public void addPhoto(Photo photo, int albumId) {

	}

	@Override
	public Photo getPhotoById(int photoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Photo> getPhotos(int albumId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deltePhoto(int photoId, int albumId) {
		// TODO Auto-generated method stub

	}

}
