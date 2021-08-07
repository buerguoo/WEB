package com.java.demo.service.impl;

import org.springframework.stereotype.Service;

import com.java.demo.model.entity.User;
import com.java.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.demo.dao.UserDao;


@Service("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userdao ;
	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userdao.getUserByEmail(email) ;
	}

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return userdao.search(userId);
	}

	@Override
	public User upateUser(User user) {
		// TODO Auto-generated method stub
		userdao.update(user);
		return user;
	}

}
