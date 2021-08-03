package com.java.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	// ID
	private int id_u;
	
	// 角色
	private String role_u;
	
	// 用户名
	private String name_u;
	
	// 密码
	private String pswd_u;
}

