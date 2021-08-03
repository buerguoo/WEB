package com.java.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Photo {
	
	// ID
	private int id;
	
	// 名称
	private String name;
	
	// 路径
	private String path;
	
	// 相册ID
	private int album;
}
