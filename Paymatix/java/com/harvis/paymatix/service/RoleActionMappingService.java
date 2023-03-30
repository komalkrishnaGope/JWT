package com.harvis.paymatix.service;

import java.util.ArrayList;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.harvis.paymatix.model.RoleActionMapping;
import com.harvis.paymatix.repository.RoleActionMappingRepository;

@Service
public class RoleActionMappingService {
	
	@Autowired
	private RoleActionMappingRepository roleActionMappingRepository;

	public Iterable <RoleActionMapping> getAllUserActionMapped() {
		return roleActionMappingRepository.findAll();
	}
	
	public ArrayList<RoleActionMapping> getRoleActionMappingById(int id) {
		return roleActionMappingRepository.getByRoleId(id);
	}
}
