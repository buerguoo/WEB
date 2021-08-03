package com.java.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
	
	// id
	private Integer id_at;
	
	// 标题
	private String title_at;
	
	// 内容
	private String content_at;
	
	// 作者
	private String author_at;
	
	// 提交时间
	private String postTime_at;
	

}
