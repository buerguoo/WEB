package com.java.demo.dao;

import java.util.Collection;

public interface Basedao<T> {
	
	void insert(T entity);
	
	T search(int id);
	
	void delete(int id);	
	
	void update(T entity);
	
	Collection<T> getAll();
}