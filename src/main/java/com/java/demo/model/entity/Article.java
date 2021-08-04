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
	private Integer id;
	
	// 标题
	private String title;
	
	// 内容
	private String content;
	
	// 提交时间
	private Timestamp updateTime;
	
	// 浏览次数
	private Integer viewCount;
}
