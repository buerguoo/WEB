package com.java.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import com.java.demo.service.ArticleCommentService;

@Controller
public class CommentController {

	@Autowired
	ArticleCommentService arciArticleCommentService;
}
