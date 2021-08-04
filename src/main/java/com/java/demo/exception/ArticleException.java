package com.java.demo.exception;

public class ArticleException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private String code;
	
	public ArticleException(String code, String message) {
		// TODO Auto-generated constructor stub
		super(message);
		this.code = code;
	}
	
	public String getCode() {
		
		return code;
	}
	
	public void setCode(String code) {
		
		this.code = code;
	}
	
}
