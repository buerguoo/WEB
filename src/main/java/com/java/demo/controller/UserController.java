package com.java.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.demo.model.entity.User;
import com.java.demo.model.utils.ResponseWrapper;
import com.java.demo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	 
	// 返回用户的信息
	// 与前端的数据以及名字不太匹配 无法获取正确的id
	// 需要调整
	@CrossOrigin
	@GetMapping("/Userinfo/getUserInfo")
	public ResponseWrapper<User> userInfo(@RequestParam("user_id") String userId) {
		
		User user = null;
				
		if(!userId.equals("undefined") && !userId.equals("") && userId != null) {
			
			System.out.println(Integer.valueOf(userId));
			
			user = userService.getUserById(Integer.valueOf(userId));
			
			System.out.println(user);
		}
		return new ResponseWrapper<>(user);
	}
	
	// 修改用户信息
	// 不匹配 无法进行 前端不合理？
	@CrossOrigin
	@GetMapping("/Userinfo/UserInfoSave")
	public ResponseWrapper<User> userInfoUpdate(){
		
		return null;
	}
		
}
