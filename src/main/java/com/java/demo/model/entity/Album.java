package com.java.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album {

	// ID
	private Integer id;
	
	// 主人
	private String owner;

	// 创建时间
	private String createTime;
	
	//相册名称
	private String name;
}

