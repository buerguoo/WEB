package com.java.demo.service;

import com.java.demo.model.entity.LikeCount;

public interface LikeService {

	Integer getLikeCount();
	
	void updateLikeCount(LikeCount likeCount);
}
