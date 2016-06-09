package com.scut.victor.dao;

import com.scut.victor.model.User;

import java.util.List;


public interface UserDao extends GenericDao<User, String> {
	
	User getUserByUserId(String userId);

	User getUserById(String id);
	
}
