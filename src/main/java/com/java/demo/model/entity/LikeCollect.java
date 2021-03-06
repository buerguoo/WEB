package com.java.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeCollect {
	//用户Id
	private Integer userId;
	//文章id
	private Integer artId;
	//类型，01表示喜欢，10表示收藏，11喜欢+收藏，00啥也不是
	private Integer type;
}
