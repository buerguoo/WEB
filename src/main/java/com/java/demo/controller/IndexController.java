package com.java.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.demo.model.entity.User;
import com.java.demo.model.utils.ResponseWrapper;
import com.java.demo.service.UserService;

@RestController
public class IndexController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login/UserLogin")
	public ResponseWrapper getEntity(@RequestParam("email") String email,
									@RequestParam("password") String password) {
		
		User user = userService.getUserByUsername(email);
		
		System.out.println(user);
		
		System.out.println(new ResponseWrapper<>(user));
		
		return new ResponseWrapper<>(user);
	}
	
}
