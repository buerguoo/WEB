package com.java.demo.model.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
	
	// id
	private Integer id;
	
	// 发布消息的用户名
	private String username;
	
	// 内容
	private String content;
	
	// 提交时间
	private Timestamp posttime;
	
}