package com.java.demo.model.response;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleResponse {

	private Integer id;
	private String title;
	private Timestamp create_time;
	private Integer browse_count;
	private Integer comment_count;
	private String cate_name;// 分类名称
	private String content;

}
