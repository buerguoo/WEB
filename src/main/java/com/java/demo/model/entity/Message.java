package com.java.demo.model.entity;

import java.sql.Timestamp;

import com.baomidou.mybatisplus.annotation.TableField;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
	
	// id
	private Integer id;
	
	// 内容
	private String content;
	
	// 提交时间
	@TableField("postTime")
	private Timestamp postTime;
	
}
