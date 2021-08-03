package com.java.demo.dao;

import com.java.demo.model.entity.User;

public interface UserDao extends Basedao<User>{
	
	// 使用用户名获取
	User getUserByName(String username);
	
}
