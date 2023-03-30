package com.harvis.paymatix.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harvis.paymatix.model.UserRoleMapping;
import com.harvis.paymatix.repository.UserRoleMappingRepository;

@Service
public class UserRoleMappingService {
	
	@Autowired
	private UserRoleMappingRepository userRoleMappingRepository;

	public Iterable <UserRoleMapping> getAllUserRoleMapped() {
		return userRoleMappingRepository.findAll();
	}
	
	public List<UserRoleMapping> getUserRoleMappingById(int id) {
		return userRoleMappingRepository.getByUserId(id);
	}
	
	public void createUserRoles(int userId, int roleId) {
		userRoleMappingRepository.createUserRole(userId, roleId);
	}
	
	public void deleteRoles(int userId) {
		userRoleMappingRepository.deleteAllRoles(userId);
	}
	
//	public void getAllRoles(int )
	
}
