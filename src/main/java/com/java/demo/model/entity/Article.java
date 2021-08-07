package com.java.demo.model.entity;

import java.sql.Timestamp;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
	
	// id
	@TableId
	@TableField("artId")
	private Integer artId;
	
	// 标题
	@TableField("articleName")
	private String articleName;
	
	//标签
	private String label;
	
	// 浏览次数
	@TableField("viewCount")
	private Integer viewCount;
	
	//评论次数
	@TableField("commentCount")
	private Integer commentCount;
	
	// 内容
	private String content;
	
	// 提交时间
	@TableField("postTime")
	private Timestamp postTime;
}
