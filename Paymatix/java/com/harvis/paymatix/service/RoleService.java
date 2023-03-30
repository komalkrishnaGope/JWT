package com.harvis.paymatix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harvis.paymatix.model.Roles;
import com.harvis.paymatix.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	public Iterable <Roles> getAllUserRole() {
		return roleRepository.findAll();
	}
	
}
