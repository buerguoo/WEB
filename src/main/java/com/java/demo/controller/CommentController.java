package com.java.demo.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.sound.midi.Soundbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.demo.model.entity.ArticleComment;
import com.java.demo.model.entity.User;
import com.java.demo.model.response.ArticleCommentResponse;
import com.java.demo.model.utils.ResponseWrapper;
import com.java.demo.service.ArticleCommentService;
import com.java.demo.service.UserService;
import com.sun.istack.internal.NotNull;

@RestController
public class CommentController {

	@Autowired
	ArticleCommentService arciArticleCommentService;

	@Autowired
	UserService userService;

	// 查询文章评论数据
	@CrossOrigin
	@GetMapping("/comment/ArticleComment")
	public ResponseWrapper<List<ArticleCommentResponse>> ArticleComment(@RequestParam("art_id") String articleId,
			@RequestParam("comment_id") String commentId) {

		// 获取文章评论, 需要增加业务
		Collection<ArticleComment> articleComments = arciArticleCommentService
				.getAllArticleComments(Integer.valueOf(articleId));

		List<ArticleCommentResponse> articleCommentResponses = new LinkedList<ArticleCommentResponse>();


		for (int i = 0; i < articleComments.size(); i++) {

			ArticleComment articleComment = articleComments.get(articleComments.size() - 1 - i);

			User user = userService.getUserById(articleComment.getUserId());

			ArticleCommentResponse articleCommentResponse = new ArticleCommentResponse();
			articleCommentResponse.setContent(articleComment.getContent());
			articleCommentResponse.setTime(articleComment.getPosttime());
			articleCommentResponses.add(articleCommentResponse);
			if (user != null) {
				articleCommentResponse.setAvatar(user.getAvatar());
				articleCommentResponse.setLabel(user.getLabel());
				articleCommentResponse.setUsername(user.getUsername());
			} else {
				articleCommentResponse.setAvatar("/static/img/tou.jpg");
				articleCommentResponse.setLabel("游客");
				articleCommentResponse.setUsername("Anonymous");
			}
		}

		return new ResponseWrapper<List<ArticleCommentResponse>>(articleCommentResponses);
	}

	// 查询其他评论数据
	@CrossOrigin
	@GetMapping("/comment/OtherComment")
	public ResponseWrapper<List<ArticleCommentResponse>> OtherComment(@RequestParam("leave_id") String leaveId,
			@RequestParam("comment_id") String commentId) {
		// 获取其他评论
		List<ArticleComment> articleComments = arciArticleCommentService
				.getAllArticleCommentsByType(Integer.valueOf(leaveId));

		List<ArticleCommentResponse> articleCommentResponses = new LinkedList<ArticleCommentResponse>();

		for (int i = 0; i < articleComments.size(); i++) {

			ArticleComment articleComment = articleComments.get(articleComments.size() - 1 - i);
			User user = userService.getUserById(articleComment.getUserId());

			ArticleCommentResponse articleCommentResponse = new ArticleCommentResponse();
			articleCommentResponse.setContent(articleComment.getContent());
			articleCommentResponse.setTime(articleComment.getPosttime());
			articleCommentResponses.add(articleCommentResponse);
			if (user != null) {
				articleCommentResponse.setAvatar(user.getAvatar());
				articleCommentResponse.setLabel(user.getLabel());
				articleCommentResponse.setUsername(user.getUsername());
			} else {
				articleCommentResponse.setAvatar("/static/img/tou.jpg");
				articleCommentResponse.setLabel("游客");
				articleCommentResponse.setUsername("Anonymous");
			}
		}

		return new ResponseWrapper<List<ArticleCommentResponse>>(articleCommentResponses);
	}

	// 添加文章评论
	@CrossOrigin
	@GetMapping("/comment/setArticleComment")
	public ResponseWrapper<ArticleComment> setArticleCommet(@RequestParam("content") String content,
			@RequestParam("user_id") String userId, @RequestParam("article_id") String articleId,
			@RequestParam("leave_id") String leaveId, @RequestParam("pid") String pId) {
		// content 内容
		// user_id 发送者id
		// article_id 文章id
		// leave_id
		// 获取当前时间

		int maxCommentId = arciArticleCommentService.getMaxCommentId();
		int tempId;
		if (userId == "") {
			tempId = -1;
		} else {
			tempId = Integer.valueOf(userId);
		}
		ArticleComment articleComment = new ArticleComment(++maxCommentId, Integer.valueOf(articleId), tempId,
				Integer.valueOf(leaveId), 0, Integer.valueOf(pId), content, new Timestamp(System.currentTimeMillis()));

		arciArticleCommentService.addArticleComment(articleComment);

		return new ResponseWrapper<>(articleComment);
	}

	// 添加其他评论
	@CrossOrigin
	@GetMapping("comment/setOuthComment")
	public ResponseWrapper<ArticleComment> setOtherComment(@RequestParam("content") String content,
			@RequestParam("user_id") String userId, @RequestParam("article_id") String articleId,
			@RequestParam("leave_id") String leaveId, @RequestParam("leave_pid") String leavePid,
			@RequestParam("pid") String pId) {
		// ...
		// http://localhost:8080/comment/setOuthComment?content=fdsaff%20&user_id=0&article_id=1&leave_id=3&leave_pid=&pid=
		int maxCommentId = arciArticleCommentService.getMaxCommentId();
		int tempId;
		if (userId == "") {
			tempId = -1;
		} else {
			tempId = Integer.valueOf(userId);
		}
		ArticleComment articleComment = new ArticleComment(++maxCommentId, Integer.valueOf(articleId), tempId,
				Integer.valueOf(leaveId), 0, 0, content, new Timestamp(System.currentTimeMillis()));

		arciArticleCommentService.addArticleComment(articleComment);

		return new ResponseWrapper<>(articleComment);
	}

}
