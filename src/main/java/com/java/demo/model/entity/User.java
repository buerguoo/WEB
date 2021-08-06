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
	
	// 密码
	private String password;	
		
	// 可自定义的邮箱地址，显示在个人信息页面
	private String email;
	
	// 头像路径
	private String avatar;

	//个性标签
	private String label;
	
	//性别
	private Integer sex;
}

