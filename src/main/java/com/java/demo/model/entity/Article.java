package com.java.demo.model.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
	
	// id
	private Integer artId;
	
	// 标题
	private String articleName;
	
	//标签
	private String label;
	
	// 浏览次数
	private Integer viewCount;
	
	//评论次数
	private Integer commentCount;
	
	// 内容
	private String content;
	
	// 提交时间
	private Timestamp postTime;
}
