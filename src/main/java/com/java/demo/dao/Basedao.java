package com.java.demo.dao;

import java.util.List;

public interface Basedao<T> {
	
	void insert(T entity);
	
	T search(Integer id);
	
	void delete(Integer id);	
	
	void update(T entity);
	
	List<T> getAll();
}
