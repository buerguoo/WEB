package com.java.demo.model.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album {

	// ID
	private Integer id;

	// 创建时间
	private Timestamp createTime;
	
	//相册名称
	private String name;
}

