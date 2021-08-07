package com.java.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.java.demo.model.entity.ArticleComment;
@Mapper
@Component
public interface ArticleCommentDao extends Basedao<ArticleComment>{
	
	public List<ArticleComment> getAllArticleComments(int articleid);
	
	// 获取当前最大的commitId
	public Integer getMaxCommentId();
	
	// 根据leaveid获取列表
	public List<ArticleComment> getAllArticleCommentsByType(Integer leaveid);
}
