package com.java.demo.service;

import com.java.demo.model.entity.User;

public interface UserService {
	
	// 使用用户名获取用户信息
	User getUserByUsername(String username);
	
	// 使用 id 获取用户
	User getUserById(int userId);
	
	// 更新用户信息
	User upateUserById(User user);
	
}
