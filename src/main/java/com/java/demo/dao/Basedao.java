package com.java.demo.dao;

import java.util.List;

public interface Basedao<T> {
	
	void insert(T entity);
	
	T search(int id);
	
	void delete(int id);	
	
	void update(T entity);
	
	List<T> getAll();
}
