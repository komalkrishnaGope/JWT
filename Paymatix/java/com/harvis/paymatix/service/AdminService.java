package com.harvis.paymatix.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.harvis.paymatix.model.Admin;
import com.harvis.paymatix.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	public Iterable <Admin> getAllAdmin() {
		Iterable<Admin> list = adminRepository.findAll();
		return list;	
	}
	
	public Optional<Admin> loginCheck(Admin admin) {
		return adminRepository.findByUserName(admin.getUserName());
	}
	
}
