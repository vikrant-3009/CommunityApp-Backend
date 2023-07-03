package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.nagarro.entity.User;
import com.nagarro.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/count")
	public Long getUsersCount() {
		return userService.getUsersCount();
	}
	
	@GetMapping("/{email}")
	public User getUser(@PathVariable String email) {
		User user = userService.getUser(email);
		
		if(user == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No User Found.");
		}
		return user;
	}
	
	@PostMapping
	public User addNewUser(@RequestBody User user) {
		User userNew = userService.addNewUser(user);
		
		if(userNew == null) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exists.");
		}
		return userNew;
	}

}
