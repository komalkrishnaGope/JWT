package com.harvis.paymatix.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harvis.paymatix.dto.UserInfo;
import com.harvis.paymatix.model.RoleActionMapping;
import com.harvis.paymatix.model.UserRoleMapping;
import com.harvis.paymatix.response.Response;
import com.harvis.paymatix.service.RoleActionMappingService;
import com.harvis.paymatix.service.UserRoleMappingService;
import com.harvis.paymatix.utility.CommonUtility;

@RestController
@CrossOrigin
@RequestMapping("/paymatix")
public class UserRoleMappingController {
	
	@Autowired
	UserRoleMappingService userRoleMappingService;
	
	@Autowired
	RoleActionMappingService roleActionMappingService;
	
	@GetMapping("/userrolemapping")  
	private Iterable <UserRoleMapping> getAllUserRoleMapped() {  
		return userRoleMappingService.getAllUserRoleMapped();
	}
	
	@GetMapping("/userinfo/{id}")
	private ResponseEntity<Response> getUserRoleMappingById(@PathVariable("id") int id) {
		
		ArrayList<RoleActionMapping> roleDetails = new ArrayList<>();
		CommonUtility utility = new CommonUtility();
		Response response;
		
		List<UserRoleMapping> userDetails = userRoleMappingService.getUserRoleMappingById(id);
        for(UserRoleMapping mapping :userDetails) {
        	ArrayList<RoleActionMapping> roleDetails1 = new ArrayList<>();
        	roleDetails1 = roleActionMappingService.getRoleActionMappingById(mapping.getRole().getRoleId());
        	for(RoleActionMapping r : roleDetails1) {
        		roleDetails.add(r);
        	}
        }
        
        UserInfo userInfo = utility.getUserInfo(userDetails, roleDetails);
        response = utility.buildResponse(Boolean.TRUE, "User Info", userInfo);
        return ResponseEntity.ok(response);
	}

	
}
