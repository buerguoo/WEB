package com.java.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.demo.model.request.ArticleRequest;
import com.java.demo.model.utils.ResponseWrapper;

@RestController
public class TestController {
	
	@CrossOrigin
	@GetMapping("/DetailShare")
	public ResponseWrapper realseArticle(@RequestBody ArticleRequest articleRequest) {
		
		System.out.println(articleRequest);
		
		return new ResponseWrapper<>(null);
		
	}
	
}
