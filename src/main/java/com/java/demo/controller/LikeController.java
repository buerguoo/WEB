package com.java.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.demo.model.entity.LikeCount;
import com.java.demo.model.utils.ResponseWrapper;
import com.java.demo.service.LikeService;

@RestController
public class LikeController {
	
	@Autowired
	private LikeService likeService;
	
	@CrossOrigin
	@GetMapping("/outh/GetLike")
	public ResponseWrapper<Integer> getLike(@RequestParam("like_num") Integer likeAdd){
		
		int likeCount = likeService.getLikeCount();
		
		LikeCount newLikeCount = new LikeCount(0, likeCount+likeAdd);
		
		likeService.updateLikeCount(newLikeCount);
		
		//System.out.println(likeCount);
		
		return new ResponseWrapper<Integer>(likeCount);
	}
	
	@CrossOrigin
	@GetMapping("/outh/showLikeData")
	public ResponseWrapper<Integer> showLike(){
		
		int likeCount = likeService.getLikeCount();
		
		//System.out.println(likeCount);
		
		return new ResponseWrapper<Integer>(likeCount);
	}
}
