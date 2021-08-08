package com.java.demo.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.demo.model.entity.Article;
import com.java.demo.model.entity.ArticleComment;
import com.java.demo.model.entity.User;
import com.java.demo.model.response.ArticleCommentResponse;
import com.java.demo.model.utils.ResponseWrapper;
import com.java.demo.service.ArticleCommentService;
import com.java.demo.service.ArticleService;
import com.java.demo.service.UserService;

@RestController
public class CommentController {

	@Autowired
	ArticleCommentService arciArticleCommentService;

	@Autowired
	UserService userService;
	
	@Autowired
	ArticleService articleService;

	// 查询文章评论数据
	@CrossOrigin
	@GetMapping("/comment/ArticleComment")
	public ResponseWrapper<List<ArticleCommentResponse>> ArticleComment(@RequestParam("art_id") Integer articleId,
			@RequestParam("comment_id") Integer pageId) {

		List<ArticleCommentResponse> articleCommentResponses = new ArrayList<>();
		// 获取文章评论, 需要增加业务
		if (articleId != null) {
			List<ArticleComment> articleComments = arciArticleCommentService.getAllArticleComments(articleId);
			Integer tempIndex = -1;
			
			for (int i = 0; i < articleComments.size(); i++) {
				if (i % 8 == 0)
					tempIndex = tempIndex + 1;
				// 按时间从新到旧排序
				ArticleComment articleComment = articleComments.get(articleComments.size() - 1 - i);
				// 获取对应的用户
				User user = userService.getUserById(articleComment.getUserId());
				// 创建返回体
				ArticleCommentResponse articleCommentResponse = null;

				if (user != null) {
					articleCommentResponse = new ArticleCommentResponse(tempIndex, articleComment.getContent(),
							user.getUsername(), user.getLabel(), articleComment.getPosttime(), user.getAvatar());
				} else {
					articleCommentResponse = new ArticleCommentResponse(tempIndex, articleComment.getContent(),
							"Anonymous", "游客", articleComment.getPosttime(), "/static/img/tou.jpg");
				}
				articleCommentResponses.add(articleCommentResponse);
			}
		}
		return new ResponseWrapper<List<ArticleCommentResponse>>(articleCommentResponses);
	}

	// 查询其他评论数据
	@CrossOrigin
	@GetMapping("/comment/OtherComment")
	public ResponseWrapper<List<ArticleCommentResponse>> OtherComment(@RequestParam("leave_id") Integer leaveId,
			@RequestParam("comment_id") Integer commentId) {
		// 获取其他评论

		List<ArticleCommentResponse> articleCommentResponses = new ArrayList<>();
		List<ArticleComment> articleComments = null;
		if (leaveId != null)
			articleComments = arciArticleCommentService.getAllArticleCommentsByType(leaveId);
		if (articleComments != null) {
			Integer tempIndex = -1;
			for (int i = 0; i < articleComments.size(); i++) {
				if (i % 8 == 0)
					tempIndex = tempIndex + 1;
				// 按时间从新到旧排序
				ArticleComment articleComment = articleComments.get(articleComments.size() - 1 - i);
				// 获取对应的用户
				User user = userService.getUserById(articleComment.getUserId());
				// 创建返回体
				ArticleCommentResponse articleCommentResponse = null;

				if (user != null) {
					articleCommentResponse = new ArticleCommentResponse(tempIndex, articleComment.getContent(),
							user.getUsername(), user.getLabel(), articleComment.getPosttime(), user.getAvatar());
				} else {
					articleCommentResponse = new ArticleCommentResponse(tempIndex, articleComment.getContent(),
							"Anonymous", "游客", articleComment.getPosttime(), "/static/img/tou.jpg");
				}
				articleCommentResponses.add(articleCommentResponse);
			}
		}
		return new ResponseWrapper<List<ArticleCommentResponse>>(articleCommentResponses);
	}

	// 添加文章评论
	@CrossOrigin
	@GetMapping("/comment/setArticleComment")
	public ResponseWrapper<ArticleComment> setArticleCommet(@RequestParam("content") String content,
			@RequestParam("user_id") Integer userId, @RequestParam("article_id") Integer articleId) {
		// content 内容
		// user_id 发送者id
		// article_id 文章id
		// leave_id
		// 获取当前时间

		int maxCommentId = arciArticleCommentService.getMaxCommentId();
		int tempId;
		if (userId == null) {
			tempId = -1;
		} else {
			tempId = Integer.valueOf(userId);
		}
		// 添加文章评论需要增加评论个数
		Article article = articleService.getArticleById(articleId);
		int tempCommentCount = article.getCommentCount();
		article.setCommentCount(++tempCommentCount);
		articleService.updateArticleById(article);
		
		ArticleComment articleComment = new ArticleComment(++maxCommentId, articleId, tempId,
				0, 0, 0, content, new Timestamp(System.currentTimeMillis()));

		arciArticleCommentService.addArticleComment(articleComment);

		return new ResponseWrapper<>(articleComment);
	}

	// 添加其他评论
	@CrossOrigin
	@GetMapping("comment/setOuthComment")
	public ResponseWrapper<ArticleCommentResponse> setOtherComment(@RequestParam("content") String content,
			@RequestParam("user_id") Integer userId, @RequestParam("article_id") Integer articleId,
			@RequestParam("leave_id") Integer leaveId, @RequestParam("leave_pid") Integer leavePid,
			@RequestParam("pid") Integer pId) {
		// ...
		// http://localhost:8080/comment/setOuthComment?content=fdsaff%20&user_id=0&article_id=1&leave_id=3&leave_pid=&pid=
		int maxCommentId = arciArticleCommentService.getMaxCommentId();
		int tempId;
		if (userId == null) {
			tempId = -1;
		} else {
			tempId = userId;
		}
		// 创建数据库对象并写入数据库
		ArticleComment articleComment = new ArticleComment(
				++maxCommentId, articleId, tempId,
				leaveId, 0, 0, content, new Timestamp(System.currentTimeMillis()));
		arciArticleCommentService.addArticleComment(articleComment);
		ArticleCommentResponse  articleCommentResponse = null;
		// 创建响应对象并返回
		
		if(tempId == -1 ) {
			articleCommentResponse=new ArticleCommentResponse(
					articleComment.getCommentId(), 
					articleComment.getContent(),
					"Anonymous", "游客", articleComment.getPosttime(), "/static/img/tou.jpg");
		}
		else {
			User user = userService.getUserById(userId);
			articleCommentResponse=	new ArticleCommentResponse(
						articleComment.getCommentId(), 
						articleComment.getContent(),
						user.getUsername(), user.getLabel(), articleComment.getPosttime(), user.getAvatar());
		}
		return new ResponseWrapper<>(articleCommentResponse);
	}

}
