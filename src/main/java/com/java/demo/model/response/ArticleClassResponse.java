package com.java.demo.model.response;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleClassResponse {
	private Integer class_id;
	private String cate_name;// 分类名称
}
