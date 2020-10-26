package com.dao;

import java.util.List;

public interface DaoContract <User, Integer>

{
	List <User> findAll();
	User findById(int user_id);
	int update(User user);
	int create(User user);
	int delete(Integer id);
}
