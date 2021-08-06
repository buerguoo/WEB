package com.java.demo.model.entity;

import java.sql.Timestamp;

import com.baomidou.mybatisplus.annotation.TableField;
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
	@TableField("commentId")
	private Integer commentId;
	
	// 文章id
	@TableField("artId")
	private Integer artId;
	
	// 用户id
	@TableField("userId")
	private Integer userId;	
	
	// 回复id
	@TableField("replyId")
	private Integer replyId;
	
	// 内容
	private String content;
	
	// 回复时间
	private Timestamp posttime;
}
