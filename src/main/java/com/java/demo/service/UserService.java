package com.java.demo.service;

import com.java.demo.model.entity.User;

public interface UserService {
	
	// 使用用户名获取用户信息
	User getUserByEmail(String email);
	
	// 使用 id 获取用户
	User getUserById(Integer userId);
	
	// 更新用户信息
	User upateUser(User user);
	
}
