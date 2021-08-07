package com.java.demo.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("User")
public class User {

	// ID
	@TableId
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

