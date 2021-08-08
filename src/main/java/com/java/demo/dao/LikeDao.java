package com.java.demo.dao;

import com.java.demo.model.entity.LikeCount;

public interface LikeDao {

	Integer getLikeCount();

	void updateLikeCount(LikeCount likeCount);

}
