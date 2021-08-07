package com.java.demo.model.entity;

import java.sql.Timestamp;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
	@TableId
	@TableField("commentId")
	private Integer commentId;
	
	// 文章id
	@TableField("artId")
	private Integer artId;
	
	// 用户id
	@TableField("userId")
	private Integer userId;	
	
	// 回复评论的当前的commentId
	@TableField("leaveId")
	private Integer leaveId;
	
	// 赞赏等其他模块的分类id
	@TableField("leavePid")
	private Integer leavePid;
	
	// 回复评论的一级commentId
	private Integer pid;
	
	// 内容
	private String content;
	
	// 回复时间
	private Timestamp posttime;
}
