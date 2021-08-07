package com.java.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.demo.model.entity.User;
import com.java.demo.model.utils.ResponseStatus;
import com.java.demo.model.utils.ResponseWrapper;
import com.java.demo.service.UserService;

@RestController
public class LoginController {

	@Autowired
	UserService userService;
	
	// 处理登录功能
	@CrossOrigin
	@GetMapping("/login/UserLogin")
	public ResponseWrapper loginCheckout(@RequestParam("email") String email,
										@RequestParam("password") String password){
				
		User user = userService.getUserByUsername(email);
		
		System.out.println(user);
		
		if(user == null) {
			// 未查询该用户
			return new ResponseWrapper<>(ResponseStatus.FIAL_2007, "fail");	
		}else {
			// 判断密码是否正确
			if(password.equals(user.getPassword())) {
				return new ResponseWrapper<>(user);
			}else {
				return new ResponseWrapper<>(ResponseStatus.FAIL_2008, "fail");
			}
			
		}
	}
	
	// 登出	
	@CrossOrigin
	@GetMapping("/login/LoginOut")
	public String LoginOut(@RequestParam("token") String token) {
		
		return "redirect:/login/UserLogin";
	}
}
