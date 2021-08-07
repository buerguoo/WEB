package com.java.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.demo.model.entity.Article;
import com.java.demo.model.entity.User;
import com.java.demo.model.utils.ResponseWrapper;

@Controller
public class AboutMeController {
	
	
	@CrossOrigin
	@RequestMapping("/outh/AboutMeData")
	//查询关于我
	public ResponseWrapper<User> ShowAboutMe(@PathParam("AboutMeData") User user)
	{
		return new ResponseWrapper<User>(user);
	}
	
	//查询喜欢列表
	@CrossOrigin
	@RequestMapping({"/article/getLikeList","article/getCollectList"})
	public ResponseWrapper<List<Article>> ShowLikeCollect(@PathParam("user_id") int userId,
															@PathParam("art_id") int artId,
															@PathParam("article_name") String name)
	{
		return null;
	}
}
