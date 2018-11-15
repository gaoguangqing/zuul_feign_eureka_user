package com.spoon.service;

import java.util.List;

import com.spoon.pojo.User;

public interface UserService {
	List<User> findAll();

	List<User> find(User user);
	
	void insert(User user);

	void update(User user);
	public void delete(Integer id);
}
