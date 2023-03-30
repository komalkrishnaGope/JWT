package com.harvis.paymatix.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harvis.paymatix.model.RoleActionMapping;

import com.harvis.paymatix.service.RoleActionMappingService;

@RestController
@CrossOrigin
@RequestMapping("/paymatix")
public class RoleActionMappingController {
	
	@Autowired
	RoleActionMappingService roleActionMappingService;
	
	@GetMapping("/actionrolemapping")  
	private Iterable <RoleActionMapping> getAllUserActionMapped() {  
		return roleActionMappingService.getAllUserActionMapped();
	}
	


}
