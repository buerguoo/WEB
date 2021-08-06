package com.java.demo.dao.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.java.demo.dao.UserDao;
import com.java.demo.mapper.UserMapper;
import com.java.demo.model.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserMapper userMapper;

	@Override
	public void insert(User entity) {

		userMapper.insert(entity);
	}

	@Override
	public User search(int id) {
		
		QueryWrapper<User> querywrapper = Wrappers.query();
		querywrapper.like("userId", id);	
		
		return userMapper.selectOne(querywrapper);
	}

	@Override
	public void delete(int id) {

		userMapper.deleteById(id);

	}

	@Override
	public void update(User entity) {
		
		userMapper.updateById(entity);
	}

	@Override
	public Collection<User> getAll() {
		
		return userMapper.selectList(null);
	}

	@Override
	public User getUserByName(String username) {

		// 只有在用户唯一的时候才能用
		QueryWrapper<User> querywrapper = Wrappers.query();
		querywrapper.like("email", username);
		
		return userMapper.selectOne(querywrapper);
	}

}
