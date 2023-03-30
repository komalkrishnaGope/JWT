package com.harvis.paymatix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harvis.paymatix.response.Response;
import com.harvis.paymatix.service.RoleService;
import com.harvis.paymatix.utility.CommonUtility;


@RestController
@CrossOrigin
@RequestMapping("/paymatix")
public class RoleController {

	@Autowired
	RoleService roleService;
	
	@GetMapping("/roles")  
	private ResponseEntity<Response> getAllUserRole() {
		CommonUtility utility = new CommonUtility();
		Response response = utility.buildResponse(Boolean.TRUE, "Roles", 
				roleService.getAllUserRole());
		return ResponseEntity.ok(response);
	}
}
