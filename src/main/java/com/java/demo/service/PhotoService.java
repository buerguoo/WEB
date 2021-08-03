package com.java.demo.service;

import java.util.Collection;

import com.java.demo.model.entity.Photo;

public interface PhotoService {
	
	// 上传图片到相册
	void addPhoto(Photo photo, int albumId);
	
	// 获取图片
	Photo getPhotoById(int photoId);
	
	// 获取全部图片
	Collection<Photo> getPhotos(int albumId);
	
	// 从相册删除图片
	void deltePhoto(int photoId, int albumId);	
}
