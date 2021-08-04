package com.java.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.demo.service.ArticleService;

@Controller
public class IndexController {
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/index")
	public String getEntity() {
		
		return null;
	}
	
}
