package com.java.demo.dao;

import java.util.List;

import com.java.demo.model.entity.Article;

public interface ArticleDao extends Basedao<Article>{

	List<Article> search(String label);

}
