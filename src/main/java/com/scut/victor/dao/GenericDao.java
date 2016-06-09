package com.scut.victor.dao;

import java.util.List;

public interface GenericDao<T,PK> {
	
	T get(PK id);
	
	PK save(T entity);
	
	void delete(PK id);
	
	T load(PK id);
	
	List<T> findAll();
	
	void persist(T entity);
	
	void saveOrUpdate(T entity);
	
	void flush();

}
