package com.java.demo.dao.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.demo.dao.MessageDao;
import com.java.demo.mapper.MessageMapper;
import com.java.demo.model.entity.Message;

@Repository
public class MessageDaoImpl implements MessageDao {

	@Autowired
	private MessageMapper messageMapper;

	@Override
	public void insert(Message entity) {

		messageMapper.insert(entity);

	}

	@Override
	public Message search(int id) {

		return messageMapper.selectById(id);
	}

	@Override
	public void delete(int id) {

		messageMapper.deleteById(id);

	}

	@Override
	public void update(Message entity) {
		
		messageMapper.updateById(entity);
		
	}

	@Override
	public List<Message> getAll() {
		
		return messageMapper.selectList(null);
		
	}
	
}
