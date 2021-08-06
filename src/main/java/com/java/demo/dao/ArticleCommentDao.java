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
	
	public int getMaxCommentId();
}
