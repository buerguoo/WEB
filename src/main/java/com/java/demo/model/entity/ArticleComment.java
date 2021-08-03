package com.java.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleComment {

	// ID
	private int id_ac;
	
	// 文章ID
	private int id_at;
	
	// 内容
	private String content_ac;
	
	// 被回复人的ID
	private int id_reply;
	
	// 回复时间
	private String time_ac;
}
