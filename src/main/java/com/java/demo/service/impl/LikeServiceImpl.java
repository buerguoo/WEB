package com.java.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.demo.dao.LikeDao;
import com.java.demo.model.entity.LikeCount;
import com.java.demo.service.LikeService;

@Service
public class LikeServiceImpl implements LikeService {
	
	@Autowired
	private LikeDao likeDao;
	
	@Override
	public Integer getLikeCount() {
		// TODO Auto-generated method stub
		return likeDao.getLikeCount();
	}

	@Override
	public void updateLikeCount(LikeCount likeCount) {
		// TODO Auto-generated method stub
		likeDao.updateLikeCount(likeCount);
	}

}
