package com.java.demo.service;

import java.util.List;

import com.java.demo.model.entity.Album;

public interface AlbumService {
	
	// 创建相册
	void addAlum(Album album);
	
	// 获取全部相册
	// 考虑获得名字 还是实体?
	List<Album> getAllAlbum();
	
	// 获取某个相册
	Album getAlbumById(Integer albumId);
	
	// 删除相册
	void deleteAlumById(Integer albumId);
	
	// 更新相册名字
	Album updateAlumNameById(Integer albumId, String newName);
	
	
}
