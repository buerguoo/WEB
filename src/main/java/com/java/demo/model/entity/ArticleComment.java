package com.java.demo.model.entity;

import java.sql.Timestamp;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("comment")
public class ArticleComment {

	// ID
	private Integer commentId;
	
	// 文章id
	private Integer artId;
	
	// 用户id
	private Integer userId;	
	
	// 回复id
	private Integer replyId;
	
	// 内容
	private String content;
	
	// 回复时间
	private Timestamp posttime;
}
