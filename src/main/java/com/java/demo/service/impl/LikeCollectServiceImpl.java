package com.java.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.demo.dao.ArticleDao;
import com.java.demo.dao.LikeCollectDao;
import com.java.demo.model.entity.Article;
import com.java.demo.model.entity.LikeCollect;
import com.java.demo.service.LikeCollectService;

@Service("LikeCollectService")
public class LikeCollectServiceImpl implements LikeCollectService{
	@Autowired
	private LikeCollectDao likeCollectDao;
	@Autowired
	private ArticleDao articledao;
	@Override
	public List<Article> getLikeCollectByUser(Integer id)
	{
		List<LikeCollect> likeCollects =  likeCollectDao.searchLikeCollectlist(id);
		List<Article> articles = new ArrayList<>();
		for(LikeCollect lc:likeCollects)
		{
			Article article = articledao.search(lc.getArtId());
			articles.add(article);
		}
		return articles;
	}
}
