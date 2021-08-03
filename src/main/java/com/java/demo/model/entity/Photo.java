package com.java.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Photo {
	
	// ID
	private int id_ph;
	
	// 名称
	private String name_ph;
	
	// 路径
	private String path_ph;
	
	// 相册ID
	private int album_ph;
}
