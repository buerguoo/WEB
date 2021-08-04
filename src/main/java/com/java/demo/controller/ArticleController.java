package com.java.demo.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.demo.model.entity.Article;
import com.java.demo.service.ArticleService;

@Controller
public class ArticleController {
	@Autowired
	ArticleService articleService;
	@RequestMapping("/article/ArticleAll")
	public String ShowArticleList()
	{
		Collection<Article> articles = articleService.getAllArticles();
		
		
		return null;
	}
}
