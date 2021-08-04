package com.java.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleComment {

	// ID
	private int floor;
	
	// 被回复人的ID
	private int ReplyFloor;
	
	//昵称
	private String nikename;
	
	// 文章ID
	private int articleId;
	
	// 内容
	private String content;
	
	
	// 回复时间
	private String time;
}
