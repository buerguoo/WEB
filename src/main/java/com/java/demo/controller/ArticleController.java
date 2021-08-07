package com.java.demo.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Git;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.demo.model.entity.Article;
import com.java.demo.model.entity.ArticleComment;
import com.java.demo.model.entity.User;
import com.java.demo.model.response.ArticleResponse;
import com.java.demo.model.response.ArticleRightResponse;
import com.java.demo.model.utils.ResponseStatus;
import com.java.demo.model.utils.ResponseWrapper;
import com.java.demo.service.ArticleCommentService;
import com.java.demo.service.ArticleService;
import com.java.demo.service.UserService;

@RestController
public class ArticleController {
	@Autowired
	ArticleService articleService;
	@Autowired
	ArticleCommentService articleCommentService;
	@Autowired
	UserService userService;

	// 获取所有文章信息
	@CrossOrigin
	@RequestMapping("/article/ShowArticleAll")
	public ResponseWrapper<List<ArticleResponse>> ShowArticle(@RequestParam("art_id") Integer artId,
			@RequestParam("cate_id") Integer cateId, @RequestParam("article_name") String articleName) {
		List<Article> articles = articleService.getAllArticles();
		List<ArticleResponse> articleResponses = new ArrayList<>();
		Integer tempId = artId;
		for (Article article : articles) {
			ArticleResponse articleResponse = new ArticleResponse(tempId++, article.getArticleName(),
					article.getPostTime(), article.getViewCount(), article.getCommentCount(), article.getLabel(),
					article.getContent());
			articleResponses.add(articleResponse);
		}
		return new ResponseWrapper<List<ArticleResponse>>(articleResponses);
	}

	// 根据id获取文章信息
	@CrossOrigin
	@RequestMapping("/article/getArticleInfo")
	public ResponseWrapper<ArticleResponse> ShowArticleInfo(@RequestParam("art_id") Integer artId,
			@RequestParam("user_id") Integer userId) {

		Article article = articleService.getArticleById(Integer.valueOf(artId));
		ArticleResponse articleResponse = null;
		ResponseWrapper<ArticleResponse> responseWrapper = null;
		if (article == null)
			responseWrapper = new ResponseWrapper<ArticleResponse>(ResponseStatus.FAIL_4000, articleResponse);
		else {
			articleResponse = new ArticleResponse(article.getArticleId(), article.getArticleName(),
					article.getPostTime(), article.getViewCount(), article.getCommentCount(), article.getLabel(),
					article.getContent());
			responseWrapper = new ResponseWrapper<ArticleResponse>(articleResponse);
		}
		return responseWrapper;
	}

	// 获取前number个评论最多的文章?????WTF为什么是个变量
	@CrossOrigin
	@RequestMapping("article/ShowArtCommentCount")
	public ResponseWrapper<List<ArticleRightResponse>> ShowMostPopularArticle() {
		Collection<Article> articles = articleService.getAllArticles();
		List<Article> as = new ArrayList<Article>();
		for (Article a : articles)
			as.add(a);
		Collections.sort(as, new Comparator<Article>() {// 重写排序函数！！！
			public int compare(Article a1, Article a2) {
				int n1 = a1.getCommentCount();
				int n2 = a2.getCommentCount();
				if (n1 > n2)
					return 1;
				else if (n1 == n2)
					return 0;
				else {
					return -1;
				}
			}
		});
		List<ArticleRightResponse> articleRightResponses = new ArrayList<>();
		for (Article article : as) {
			ArticleComment articleComment = articleCommentService.getLastArticleComment(article.getArticleId());
			User user = userService.getUserById(articleComment.getUserId());
			ArticleRightResponse articleRightResponse = new ArticleRightResponse(article.getArticleId(),
					user.getAvatar(), user.getUsername(), article.getArticleName(), articleComment.getContent());
			articleRightResponses.add(articleRightResponse);
		}
		if (articleRightResponses.size() < 10)
			return new ResponseWrapper<List<ArticleRightResponse>>(articleRightResponses);
		else
			return new ResponseWrapper<List<ArticleRightResponse>>(articleRightResponses.subList(0, 10));
	}

	@CrossOrigin
	@RequestMapping("article/ShowBrowseCount")
	public ResponseWrapper<List<ArticleRightResponse>> ShowMostViewedArticle() {
		Collection<Article> articles = articleService.getAllArticles();
		List<Article> as = new ArrayList<Article>();
		for (Article a : articles)
			as.add(a);
		Collections.sort(as, new Comparator<Article>() {// 重写排序函数！！！
			public int compare(Article a1, Article a2) {
				int n1 = a1.getViewCount();
				int n2 = a2.getViewCount();
				if (n1 > n2)
					return 1;
				else if (n1 == n2)
					return 0;
				else {
					return -1;
				}
			}
		});
		List<ArticleRightResponse> articleRightResponses = new ArrayList<>();
		for (Article article : as) {
			ArticleComment articleComment = articleCommentService.getLastArticleComment(article.getArticleId());
			User user = userService.getUserById(articleComment.getUserId());
			ArticleRightResponse articleRightResponse = new ArticleRightResponse(article.getArticleId(),
					user.getAvatar(), user.getUsername(), article.getArticleName(), articleComment.getContent());
			articleRightResponses.add(articleRightResponse);
		}
		if (articleRightResponses.size() < 10)
			return new ResponseWrapper<List<ArticleRightResponse>>(articleRightResponses);
		else
			return new ResponseWrapper<List<ArticleRightResponse>>(articleRightResponses.subList(0, 10));
	}

	@CrossOrigin
	@RequestMapping({ "/article/ArtClassData" })
	public ResponseWrapper<List<ArticleResponse>> ShowArtClassSearch() {
		List<Article> as = articleService.getAllArticles();
		List<ArticleResponse> articleResponses = new ArrayList<>();
		for (Article article : as) {
			ArticleResponse articleResponse = new ArticleResponse(article.getArticleId(), article.getArticleName(),
					article.getPostTime(), article.getViewCount(), article.getCommentCount(), article.getLabel(),
					article.getContent());
			articleResponses.add(articleResponse);
		}
		return new ResponseWrapper<List<ArticleResponse>>(articleResponses);
	}

	@CrossOrigin
	@RequestMapping("/article/edit")
	public ResponseWrapper<String> postArticle(@RequestParam("title") String title, @RequestParam("content") String content) {
		Integer maxId = articleService.getMaxArticleId();
		Article article = new Article(maxId + 1, title, "日记", 0, 0, content, new Timestamp(System.currentTimeMillis()));
		articleService.addArticle(article);
		return new ResponseWrapper<String>(article.getArticleName());
	}
}
