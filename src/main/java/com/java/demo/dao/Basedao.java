package com.java.demo.dao;

public interface Basedao<T> {
	
	void insert(T entity);
	
	T search(int id);
	
	void delete(int id);	
}
