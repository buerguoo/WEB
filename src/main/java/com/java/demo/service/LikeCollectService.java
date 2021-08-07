package com.java.demo.service;

import java.util.List;

import com.java.demo.model.entity.Article;

public interface LikeCollectService {

	List<Article> getLikeCollectByUser(Integer id);

}
