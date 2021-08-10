package com.java.demo.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.demo.dao.LikeDao;
import com.java.demo.mapper.LikeMapper;
import com.java.demo.model.entity.LikeCount;

@Repository
public class LikeDaoImpl implements LikeDao {
	
	@Autowired
	private LikeMapper likeMapper;
	
	@Override
	public Integer getLikeCount() {
		
		LikeCount likeCount = likeMapper.selectById(0);
		
		return likeCount.getLikeCount();
	}

	@Override
	public void updateLikeCount(LikeCount likeCount) {
		// TODO Auto-generated method stub
		likeMapper.updateById(likeCount);
	}

}
