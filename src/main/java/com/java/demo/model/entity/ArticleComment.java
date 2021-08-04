package com.java.demo.model.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleComment {

	// ID
	private Integer id;
	
	// 楼层
	private Integer floor;
	
	// 回复楼层
	private Integer replyFloor;
	
	// 内容
	private String content;
	
	// 发布人的名字
	private String username;
	
	// 回复时间
	private Timestamp posttime;
}
