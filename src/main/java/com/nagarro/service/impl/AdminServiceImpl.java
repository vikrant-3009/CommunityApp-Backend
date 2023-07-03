package com.nagarro.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.entity.Admin;
import com.nagarro.repository.AdminRepository;
import com.nagarro.service.AdminService;

/** Service to get admin related details */
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}

	@Override
	public Admin getAdmin(String email) {
		Optional<Admin> admin = adminRepository.findById(email);
		return admin.isPresent() ? admin.get() : null;		
	}

	@Override
	public Admin addNewAdmin(Admin admin) {
		Admin adminCheck = getAdmin(admin.getEmail());

		if (adminCheck != null) {
			return null;
		}
		return adminRepository.save(admin);
	}

}
