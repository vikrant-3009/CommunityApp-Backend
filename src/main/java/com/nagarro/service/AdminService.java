package com.nagarro.service;

import java.util.List;

import com.nagarro.entity.Admin;

public interface AdminService {
	
	public List<Admin> getAllAdmins();
	
	public Admin getAdmin(String email);
	
	public Admin addNewAdmin(Admin admin);
	
}
