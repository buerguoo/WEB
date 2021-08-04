package com.java.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.demo.service.ArticleCommentService;

@Controller
public class CommentController {

	@Autowired
	ArticleCommentService arciArticleCommentService;
}
