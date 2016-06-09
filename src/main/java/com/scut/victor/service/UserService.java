package com.scut.victor.service;

import com.scut.victor.model.User;

import java.util.List;


public interface UserService {

	User load(String id);

	User get(String id);

	List<User> findAll();

	void persist(User entity);

	String save(User entity);

	void saveOrUpdate(User entity);

	void delete(String id);

	void flush();
	
	User searchUserEqualUserId(String userId);
	
	User getUserModelById(String id);

	User login(User user);
}
