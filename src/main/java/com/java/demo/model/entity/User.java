package com.java.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	// ID
	private Integer id;
	
	// 昵称 用于显示给游客
	private String name;
	
	// 用户名
	private String account;
	
	// 密码
	private String password;
}

