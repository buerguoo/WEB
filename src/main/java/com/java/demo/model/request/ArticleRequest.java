package com.java.demo.model.request;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ArticleRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;

    private Long id;

    private Long userId;

    //@NotBlank(message = "标题不能为空")
    private String title;

    //@NotBlank(message = "摘要不能为空")
    private String description;

    //@NotBlank(message = "内容不能为空")
    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created;

    private Integer status;
	
}
