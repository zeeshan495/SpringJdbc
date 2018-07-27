package com.bridgeit.spring.jdbc.dao;

import java.util.List;

import com.bridgeit.spring.jdbc.model.User;

public interface UserDao {
	
	public void save(User user);

	public User getById(int id);

	public void update(User user,int userId);
	
	public void deleteById(int id);

	public List<User> displayAll();

}
