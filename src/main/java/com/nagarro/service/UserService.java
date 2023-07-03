package com.nagarro.service;

import java.util.List;

import com.nagarro.entity.User;

public interface UserService {
	
	public List<User> getAllUsers();
	
	public Long getUsersCount();
	
	public User getUser(String email);
	
	public User addNewUser(User user);
	
}
