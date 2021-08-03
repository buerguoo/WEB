package com.java.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album {

	// ID
	private int id_al;
	
	// 主人
	private String owner_al;

	// 创建时间
	private String createTime_al;
}

