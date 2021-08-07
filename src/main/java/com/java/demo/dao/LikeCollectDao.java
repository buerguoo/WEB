package com.java.demo.dao;

import java.util.List;

import com.java.demo.model.entity.LikeCollect;

public interface LikeCollectDao extends Basedao<LikeCollect>  {

	List<LikeCollect> searchLikeCollectlist(int id);
	
}
