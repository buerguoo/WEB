package com.java.demo.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.demo.model.entity.Article;
import com.java.demo.model.entity.ArticleComment;
import com.java.demo.model.entity.User;
import com.java.demo.model.response.ArticleClassResponse;
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
		// 初始化
		List<ArticleResponse> articleResponses = new ArrayList<>();
		// 获取所有文章
		List<Article> articles = articleService.getAllArticles();
		// 贴上标签
		// 有分类信息的
		String tempLabel = null;
		if (cateId != null&&cateId!=0) {

			switch (cateId) {
			case 1:
				tempLabel = "日记";
				break;
			case 2:
				tempLabel = "技术";
				break;
			case 3:
				tempLabel = "美食";
				break;
			case 4:
				tempLabel = "感悟";
				break;
			default:
				break;
			}
			
			// 根据标签查找
			articles = articleService.getArticlesByLabel(tempLabel);
		}
		// articleName参数不为空，则根据关键字查找
		if (articleName != "") {
			articles = articleService.getSearchArticles(articleName);
		}
		try {
			Integer tempId = artId;
			int size = articles.size();
			for (int i = 0; i < size; ++i) {
				Article article = articles.get(size - 1 - i);

				ArticleResponse articleResponse = new ArticleResponse(article.getArticleId(), article.getArticleName(),
						article.getPostTime(), article.getViewCount(), article.getCommentCount(), article.getLabel(),
						article.getContent());
				articleResponses.add(articleResponse);

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("获取文章所有信息出错");
		}
		return new ResponseWrapper<List<ArticleResponse>>(articleResponses);
	}

	// 根据id获取文章信息
	@CrossOrigin
	@RequestMapping("/article/getArticleInfo")
	public ResponseWrapper<ArticleResponse> ShowArticleInfo(@RequestParam("art_id") Integer artId,
			@RequestParam("user_id") Integer userId) {

		Article article = articleService.getArticleById(artId);
		ArticleResponse articleResponse = null;
		ResponseWrapper<ArticleResponse> responseWrapper = null;

		if (article == null) {
			responseWrapper = new ResponseWrapper<ArticleResponse>(ResponseStatus.FAIL_4000, articleResponse);
			System.err.println("根据id查找文章失败");
		} else {
			// 获取文章id后要增加浏览次数
			Integer tempViewCount = article.getViewCount();
			article.setViewCount(++tempViewCount);
			articleService.updateArticleById(article);

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
		try {
		Collections.sort(as, new Comparator<Article>() {
			public int compare(Article a1, Article a2) {
				int n1 = a1.getCommentCount();
				int n2 = a2.getCommentCount();
				if (n1 > n2)
					return -1;
				else if (n1 == n2)
					return 0;
				else {
					return 1;
				}
			}
		});
		}catch (Exception e) {
			e.printStackTrace();
			System.err.println("阿兴你个混蛋");
		}
		List<ArticleRightResponse> articleRightResponses = new ArrayList<>();
		for (Article article : as) {
			ArticleComment articleComment = articleCommentService.getLastArticleComment(article.getArticleId());
			if (articleComment != null) {
				User user = userService.getUserById(articleComment.getUserId());
				ArticleRightResponse articleRightResponse = null;
				if (user != null) {
					articleRightResponse = new ArticleRightResponse(article.getArticleId(), user.getAvatar(),
							user.getUsername(), article.getArticleName(), articleComment.getContent(),
							article.getViewCount());
				} else {
					articleRightResponse = new ArticleRightResponse(article.getArticleId(), "/static/img/tou.jpg",
							articleComment.getTempname() + "[" + articleComment.getTempemail() + "]",
							article.getArticleName(), articleComment.getContent(), article.getViewCount());

				}
				articleRightResponses.add(articleRightResponse);
			} else {
				break;
			}
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
		try {
		Collections.sort(as, new Comparator<Article>() {// 重写排序函数！！！
			public int compare(Article a1, Article a2) {
				int n1 = a1.getViewCount();
				int n2 = a2.getViewCount();
				if (n1 > n2)
					return -1;
				else if (n1 == n2)
					return 0;
				else {
					return 1;
				}
			}
		});
		}catch (Exception e) {
			e.printStackTrace();
			System.err.println("阿兴你不是人");
		}
		List<ArticleRightResponse> articleRightResponses = new ArrayList<>();
		for (Article article : as) {
			ArticleComment articleComment = articleCommentService.getLastArticleComment(article.getArticleId());
			if (articleComment != null) {
				User user = userService.getUserById(articleComment.getUserId());
				ArticleRightResponse articleRightResponse = null;
				if (user != null) {
					articleRightResponse = new ArticleRightResponse(article.getArticleId(), user.getAvatar(),
							user.getUsername(), article.getArticleName(), articleComment.getContent(),
							article.getViewCount());
				} else {
					articleRightResponse = new ArticleRightResponse(article.getArticleId(), "/static/img/tou.jpg",
							articleComment.getTempname() + "[" + articleComment.getTempemail() + "]",
							article.getArticleName(), articleComment.getContent(), article.getViewCount());

				}
				articleRightResponses.add(articleRightResponse);
			} else {
				break;
			}
		}
		if (articleRightResponses.size() < 10)
			return new ResponseWrapper<List<ArticleRightResponse>>(articleRightResponses);
		else
			return new ResponseWrapper<List<ArticleRightResponse>>(articleRightResponses.subList(0, 10));
	}

	@CrossOrigin
	@RequestMapping({ "/article/ArtClassData" })

	public ResponseWrapper<List<ArticleClassResponse>> ShowArtClassSearch() {
		List<ArticleClassResponse> articleClassList = new ArrayList<>();
		ArticleClassResponse[] articleClassResponses = new ArticleClassResponse[4];
		articleClassResponses[0] = new ArticleClassResponse(1, "日记");
		articleClassResponses[1] = new ArticleClassResponse(2, "技术");
		articleClassResponses[2] = new ArticleClassResponse(3, "美食");
		articleClassResponses[3] = new ArticleClassResponse(4, "感悟");
		for (ArticleClassResponse articleClassResponse : articleClassResponses) {
			articleClassList.add(articleClassResponse);
		}
		return new ResponseWrapper<List<ArticleClassResponse>>(articleClassList);

	}


	@CrossOrigin
	@RequestMapping("/article/edit")
	public ResponseWrapper<String> postArticle(@RequestParam("title") String title,
			@RequestParam("content") String content, @RequestParam("label") String label) {
		Integer maxId = articleService.getMaxArticleId();
		Article article = new Article(maxId + 1, title, label, 0, 0, content,
				new Timestamp(System.currentTimeMillis()));
		articleService.addArticle(article);
		return new ResponseWrapper<String>(article.getArticleName());
	}
}
