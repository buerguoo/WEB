package com.java.demo.model.response;

import java.sql.Time;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCommentResponse {
	
	private Integer commentId;
	private String content;
	private String username;
	private String 	label;
	private Timestamp time;
	private String avatar;
	
}
