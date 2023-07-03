package com.nagarro.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.entity.User;
import com.nagarro.repository.UserRepository;
import com.nagarro.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@Override
	public Long getUsersCount() {
		return userRepository.count();
	}
	
	@Override
	public User getUser(String email) {
		Optional<User> user = userRepository.findById(email);
		
		if(user.isEmpty()) {
			return null;
		}
		return user.get();
	}

	@Override
	public User addNewUser(User user) {
		User user_new = getUser(user.getEmail());
		
		if(user_new != null) {
			return null;
		}
		return userRepository.save(user);
	}

}
