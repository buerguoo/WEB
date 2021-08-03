package com.java.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleComment {

	// ID
	private int id;
	
	// 文章ID
	private int articleId;
	
	// 内容
	private String content;
	
	// 被回复人的ID
	private int idReply;
	
	// 回复时间
	private String time;
}
