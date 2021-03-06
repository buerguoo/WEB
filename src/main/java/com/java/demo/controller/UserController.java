package com.java.demo.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.java.demo.model.entity.User;

import com.java.demo.model.utils.ResponseWrapper;
import com.java.demo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	 
	// 返回用户的信息
	@CrossOrigin
	@GetMapping("/Userinfo/getUserInfo")
	public ResponseWrapper<User> userInfo(@RequestParam("user_id") String userId) {
		
		User user = null;
		
		//System.out.println(userId);
		
		if(!userId.equals("undefined") && !userId.equals("") && userId != null) {
						
			user = userService.getUserById(Integer.valueOf(userId));
			
			//System.out.println(user);
			
		}
		return new ResponseWrapper<>(user);
	}
	
	// 修改用户信息
	@CrossOrigin
	@RequestMapping("/Userinfo/UserInfoSave")
	public ResponseWrapper<User> userInfoUpdate(@RequestParam("username") String username,
												@RequestParam("user_img") String avatar,
												@RequestParam("email") String email,
												@RequestParam("sex") String sex,
												@RequestParam("label") String label){

		
		User oldUser = userService.getUserByEmail(email);		
		User newUser = new User(oldUser.getUserId(), username, oldUser.getPassword(), email, avatar, label, Integer.valueOf(sex));
		userService.upateUser(newUser);
		
		return new ResponseWrapper<>(newUser);
	}
}
