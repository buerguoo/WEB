package com.java.demo.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleRightResponse {
	
	Integer id;
	String avatar;
	String nickname;
	String title;
	String content;
	
}
