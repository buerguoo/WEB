package com.java.demo.model.entity;

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
	
	// 作者
	private String author;
	
	// 提交时间
	private String postTime;
	
	// 评论个数
	private Integer commentCount;
	
	// 浏览次数
	private Integer viewCount;
}
