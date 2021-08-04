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
	private Integer id;
	
	// 文章id
	private Integer articleid;
	
	// 楼层
	private Integer floor;	
	
	// 回复楼层
	private Integer replyfloor;
	
	// 内容
	private String content;
	
	// 发布人的名字
	private String username;
	
	// 回复时间
	private Timestamp posttime;
}
