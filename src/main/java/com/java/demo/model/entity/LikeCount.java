package com.java.demo.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("likecount")
public class LikeCount {
	
	private Integer id;
	
	@TableField("likeCount")
	private Integer likeCount;
	
}
