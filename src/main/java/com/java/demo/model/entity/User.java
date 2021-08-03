package com.java.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	// ID
	private int id;
	
	// 角色
	private String role;
	
	// 用户名
	private String name;
	
	// 密码
	private String pswd;
}

