package com.java.demo.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.demo.model.entity.ArticleComment;
import com.java.demo.model.utils.ResponseWrapper;
import com.java.demo.service.ArticleCommentService;

@RestController
public class CommentController {

	@Autowired
	ArticleCommentService arciArticleCommentService;
	
	// 查询文章评论数据
	@CrossOrigin
	@GetMapping("/comment/ArticleComment")
	public ResponseWrapper<List<ArticleComment>> ArticleComment(@RequestParam("art_id") String articleId,
										@RequestParam("comment_id") String commentId) {
		
		// 获取文章评论, 需要增加业务
		List<ArticleComment> articleComments = arciArticleCommentService.getArticleCommentsByArticleId(Integer.valueOf(articleId));
		
		return new ResponseWrapper<List<ArticleComment>>(articleComments);
	}
	
	// 查询其他评论数据
	@CrossOrigin
	@GetMapping("/comment/OtherComment")
	public ResponseWrapper<List<ArticleComment>> OtherComment(@RequestParam("leave_id") String leaveId, 
														@RequestParam("comment_id") String commentId){
		// 获取其他评论
		List<ArticleComment> articleComments = arciArticleCommentService.getArticleCommentsByLeaveId(Integer.valueOf(leaveId));
		
		return new ResponseWrapper<List<ArticleComment>>(articleComments);
	}
	
	// 添加文章评论
	@CrossOrigin
	@GetMapping("/comment/setArticleComment")
	public ResponseWrapper<ArticleComment> setArticleCommet(@RequestParam("content") String content,
											@RequestParam("user_id") String userId, 
											@RequestParam("article_id") String articleId,
											@RequestParam("leave_id") String leaveId, 
											@RequestParam("pid") String pId) {
		// content 内容
		// user_id 发送者id
		// article_id 文章id
		// leave_id 
		// 获取当前时间
		
		int maxCommentId = arciArticleCommentService.getMaxCommentId();
		
		ArticleComment articleComment = new ArticleComment(++maxCommentId , 
				Integer.valueOf(articleId), Integer.valueOf(userId), Integer.valueOf(leaveId), 0, Integer.valueOf(pId), content, new Timestamp(System.currentTimeMillis()));
		
		arciArticleCommentService.addArticleComment(articleComment);
		
		return new ResponseWrapper<>(articleComment);
	}
	
	// 添加其他评论
	@CrossOrigin
	@GetMapping("comment/setOuthComment")
	public ResponseWrapper<ArticleComment> setOtherComment(@RequestParam("content") String content,
										   @RequestParam("user_id") String userId, 
										   @RequestParam("article_id") String articleId,
										   @RequestParam("leave_id") String leaveId, 
										   @RequestParam("leave_pid") String leavePid,
										   @RequestParam("pid") String pId){
		// ...
		//http://localhost:8080/comment/setOuthComment?content=fdsaff%20&user_id=0&article_id=1&leave_id=3&leave_pid=&pid=
		int maxCommentId = arciArticleCommentService.getMaxCommentId();
		
		ArticleComment articleComment = new ArticleComment( ++maxCommentId, 
				Integer.valueOf(articleId), Integer.valueOf(userId), Integer.valueOf(leaveId), 0, 0, content, new Timestamp(System.currentTimeMillis()));
		
		arciArticleCommentService.addArticleComment(articleComment);

		
		return new ResponseWrapper<>(articleComment);
	}
	
}
