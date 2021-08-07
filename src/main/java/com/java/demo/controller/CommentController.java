package com.java.demo.controller;

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
	public ResponseWrapper<ArticleComment> ArticleComment(@RequestParam("art_id") String articleId,
										@RequestParam("comment_id") String commentId) {
		
		// 获取单个评论, 需要增加业务
		//ArticleComment articleComment = arciArticleCommentService.getAticleComment(articleId, commentId)
		
		//return new ResponseWrapper<ArticleComment>(articleComment)
		return null;
	}
	
	// 查询其他评论数据
	@CrossOrigin
	@GetMapping("/comment/OtherComment")
	public ResponseWrapper<ArticleComment> OtherComment(@RequestParam("leave_id") String leaveId, 
														@RequestParam("comment_id") String commentId){
		// 获取其他评论
		//ArticleComment articleComment = arciArticleCommentService.getOtherCommet(leaveId, commentId);
		
		//return new ResponseWrapper<ArticleComment>(articleComment);
		return null;
	}
	
	// 添加文章评论
	@CrossOrigin
	@GetMapping("/comment/setArticleComment")
	public ResponseWrapper setArticleCommet(@RequestParam("content") String content,
											@RequestParam("user_id") String userId, 
											@RequestParam("article_id") String articleId,
											@RequestParam("leave_id") String leaveId, 
											@RequestParam("pid") String pId) {
		// content 内容
		// user_id 发送者id
		// article_id 文章id
		// leave_id 
		// pid 
		// pid 是什么？
		// ...
		//arciArticleCommentService.addArticleComment(new ArticleComment(id, articleId, floor, replyfloor, content, username, posttime));
		
		//return new ResponseWrapper<>(null);
		return null;
	}
	
	// 添加其他评论
	@CrossOrigin
	@GetMapping("comment/setOuthComment")
	public ResponseWrapper setOtherComment(@RequestParam("content") String content,
										   @RequestParam("user_id") String userId, 
										   @RequestParam("article_id") String articleId,
										   @RequestParam("leave_id") String leaveId, 
										   @RequestParam("leave_pid") String leavePid,
										   @RequestParam("pid") String pId){
		// ...
		
		return null;
	}
	
}
