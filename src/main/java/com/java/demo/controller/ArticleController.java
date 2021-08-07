package com.java.demo.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Git;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.demo.model.entity.Article;
import com.java.demo.model.utils.ResponseStatus;
import com.java.demo.model.utils.ResponseWrapper;
import com.java.demo.service.ArticleService;

@Controller
public class ArticleController {
	@Autowired
	ArticleService articleService;
	//获取所有文章信息
	@CrossOrigin
	@RequestMapping({"/article/ShowArticleAll","/nav/ActiveClassAllData"})
	public ResponseWrapper<Article> ShowArticleList(@PathParam("art_id") int artId,
																@PathParam("cate_id") int cateId,
																@PathParam("article_name") String artname)
	{
		Article article = articleService.getArticleById(artId);
		if(article.getArticleName()==artname)
			return new ResponseWrapper<Article>(article);
		else {
			return new ResponseWrapper<Article>(ResponseStatus.FAIL_4000 ,article);
		}
	}	
	
	//根据id获取文章信息
	@CrossOrigin
	@RequestMapping("/article/getArticleInfo")
	public ResponseWrapper<Article> ShowArticleInfo(@PathVariable("art_id") int articleId)
	{
		Article article = articleService.getArticleById(articleId);
		
		ResponseWrapper<Article> responseWrapper = null;
		if(article == null)
			responseWrapper = new ResponseWrapper<Article>(ResponseStatus.FAIL_4000,article);
		else {
			responseWrapper = new ResponseWrapper<Article>(article);
		}
		return responseWrapper;
	}
	
	//获取前number个评论最多的文章
	@CrossOrigin
	@RequestMapping("/article/ShowArtCommentCount")
	public ResponseWrapper<List<Article>> ShowMostPopularArticle(int number)
	{
		Collection<Article> articles = articleService.getAllArticles();
		List<Article> as = new ArrayList<Article>();
		for(Article a:articles)
			as.add(a);
		Collections.sort(as,new Comparator<Article>() {
			public int compare(Article a1,Article a2)
			{
				int n1 = articleService.getCommentCount(a1.getArticleId());
				int n2 = articleService.getCommentCount(a2.getArticleId());
				if(n1>n2)
					return 1;
				else if(n1==n2)
					return 0;
				else {
					return -1;
				}
			}
		});
		if(as.size()<number)
			return new ResponseWrapper<List<Article>>(as);
		else 
			return new ResponseWrapper<List<Article>>(as.subList(0, number));
	}
	
	@CrossOrigin
	@RequestMapping("/article/ArtClassData")
	public ResponseWrapper<Collection<Article>> ShowArtClassSearch(@RequestParam(value="label",required = false) String label )
	{
		Collection<Article> as = articleService.getArticlesByLabel(label);
		return new ResponseWrapper<Collection<Article>>(as);
//		System.out.println(id);
//		return null;
	}
	
}
