package com.java.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	// ID
	private Integer userId;
	
	// 用户名
	private String username;
	
	// 
	private String email;
	
	// 密码
	private String password;
	
	private String avatar;
	
	private String label;
	
	private Integer sex;
}

