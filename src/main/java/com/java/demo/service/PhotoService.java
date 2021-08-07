package com.java.demo.service;

import java.util.List;

import com.java.demo.model.entity.Photo;

public interface PhotoService {
	
	// 上传图片到相册
	void addPhoto(Photo photo);
	
	// 获取图片
	Photo getPhotoById(Integer photoId);
	
	// 获取全部图片
	List<Photo> getPhotos(Integer albumId);
	
	// 从相册删除图片
	void deltePhoto(Integer photoId, Integer albumId);	
}
