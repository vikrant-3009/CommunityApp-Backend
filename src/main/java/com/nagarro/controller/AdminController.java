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

import com.nagarro.entity.Admin;
import com.nagarro.service.AdminService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:4200/")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping
	public List<Admin> getAllAdmins() {
		return adminService.getAllAdmins();
	}
	
	@GetMapping("/{email}")
	public Admin getAdmin(@PathVariable String email) {
		Admin admin = adminService.getAdmin(email);
		
		if(admin == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin does not exists.");
		}
		return admin;
	}
	
	@PostMapping
	public Admin addNewAdmin(@RequestBody Admin admin) {
		Admin adminNew = adminService.addNewAdmin(admin);
		
		if(adminNew == null) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Admin already present.");
		}
		return adminNew;
	}
	
}
