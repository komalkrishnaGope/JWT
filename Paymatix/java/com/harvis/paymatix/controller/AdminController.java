package com.harvis.paymatix.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harvis.paymatix.beans.PasswordEncrypt;
import com.harvis.paymatix.beans.Roles;
import com.harvis.paymatix.beans.UserData;
import com.harvis.paymatix.dto.UserResponse;
import com.harvis.paymatix.model.Admin;
import com.harvis.paymatix.model.Users;
import com.harvis.paymatix.response.Response;
import com.harvis.paymatix.service.AdminService;
import com.harvis.paymatix.service.UserRoleMappingService;
import com.harvis.paymatix.service.UserService;
import com.harvis.paymatix.utility.CommonUtility;

@RestController
@CrossOrigin
@RequestMapping("/paymatix")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRoleMappingService roleMappingService;

	PasswordEncrypt crypt = new PasswordEncrypt();
	CommonUtility utility = new CommonUtility();
	
	Response response;
	
	@GetMapping("/admin")  
	private Iterable <Admin> getAllAdmin() {  
		return adminService.getAllAdmin();
	}
	

	@GetMapping("/user/{id}")  
	private ResponseEntity<Response> getUserById(@PathVariable("id") int id) {
		CommonUtility utility = new CommonUtility();
		Optional <Users> user = userService.getUserById(id);
		UserResponse getUser = utility.getUserData(user);
		return ResponseEntity.ok(utility.buildResponse(Boolean.TRUE, "User detail", getUser));
	}
	
	@PostMapping("/adminlogin")
	private ResponseEntity<Response> login(@RequestBody Admin admin){
		
		Optional<Admin> adminDetails = adminService.loginCheck(admin);
		Response response;
		
		if(!adminDetails.isPresent()) {
			response = utility.buildResponse(Boolean.FALSE, "Check up the username of admin", null);
			return ResponseEntity.ok(response);
		}
		
		String enteredpassword = admin.getPassword();
		String encryptedpass = adminDetails.get().getPassword();
		String dbPassword = crypt.decrypt(encryptedpass);
		
		if(!enteredpassword.equals(dbPassword)) {
			response = utility.buildResponse(Boolean.FALSE, "Password is Wrong", null);
			return ResponseEntity.ok(response);
		}
		
		response = utility.buildResponse(Boolean.TRUE, "Successfully logged in", utility.getAdminData(adminDetails));
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/createUser")
	private ResponseEntity<Response> createUser(@RequestBody UserData data) {
		try {
		CommonUtility utility = new CommonUtility();
		Users user = new Users();
		
		String enteredUsername = data.getUsername();	
		Optional<Users> userCheck = userService.userCheck(enteredUsername);
		if(userCheck.isPresent()) {
			response = utility.buildResponse(Boolean.FALSE, "Username is exists, Please enter new username", null);
			return ResponseEntity.ok(response);
		}
		
		String enteredEmail = data.getUserEmail();
		Optional<Users> emailCheck = userService.emailCheck(enteredEmail);
		if(emailCheck.isPresent()) {
			response = utility.buildResponse(Boolean.FALSE, "Email is exists, Please enter new email", null);
			return ResponseEntity.ok(response);
		}
		Date createdDate = null;
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		createdDate = formatter.parse(formatter.format(date));
		
		String toEncrypt = data.getPassword();
		String encrypted = crypt.encrypt(toEncrypt);
//		System.out.println(encrypted);
//		String decryptedOne =crypt.decrypt(encrypted);
//		System.out.println(decryptedOne);
		
		user.setUserName(enteredUsername);
		user.setPassword(encrypted);
		user.setEmail(data.getUserEmail());
		user.setCreatedOn(createdDate);
		user.setModifiedDate(null);
		user.setIsActive(true);
		
		userService.saveUser(user);

		Optional<Users> forUserId = userService.userCheck(enteredUsername);
		int newUser = forUserId.get().getUserId();
		List<Roles> allRoles = data.getRoles();
		for(Roles role : allRoles) {
			int newRoleId = role.getRoleId();
			roleMappingService.createUserRoles(newUser, newRoleId);
		}
		
		response = utility.buildResponse(Boolean.TRUE, "UserUpdated", null);
		return ResponseEntity.ok(response);
		
		} catch (Exception e) {
			e.printStackTrace();
			CommonUtility utility = new CommonUtility();
			response = utility.buildResponse(Boolean.FALSE, "Exception Occured", null);
			return ResponseEntity.ok(response);
		}
		
	}
	
	@PostMapping("/editUser")
	private ResponseEntity<Response> editUser(@RequestBody UserData data) {
		try {
			int editUserId = data.getUserId();
			
			String editEmail = data.getUserEmail();
			List<Roles> allRoles = data.getRoles();
			
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			Date date = new Date(System.currentTimeMillis());
			Date modifiedDate = null;
			modifiedDate = formatter.parse(formatter.format(date));
			
			Optional<Users> emailCheck = userService.emailCheck(editEmail);
			if(emailCheck.isPresent()) {
				response = utility.buildResponse(Boolean.FALSE, "Email is exists, Please enter new email", null);
				return ResponseEntity.ok(response);
			}
			
			userService.editUser(editUserId, editEmail, modifiedDate);
			
			int listSize = allRoles.size();
			if(listSize == 0) {
				response = utility.buildResponse(true, "Username Edited Successfully", null);
				return ResponseEntity.ok(response);
			}
			
			roleMappingService.deleteRoles(editUserId);
			for(Roles role : allRoles) {
				int newRoleId = role.getRoleId();
				roleMappingService.createUserRoles(editUserId, newRoleId);
			}
			
			response = utility.buildResponse(true, "User Edited Successfully", null);
			return ResponseEntity.ok(response);
			
		}	catch (Exception e) {
			e.printStackTrace();
			response = utility.buildResponse(false, "Unknown Error Occured", null);
			return ResponseEntity.ok(response);
		}
		
	}
	
	@PostMapping("/deactivateUser/{id}")
	private ResponseEntity<Response> deactivateUser(@PathVariable("id") int id) {
		
		userService.deactivateUser(id);
		response = utility.buildResponse(true, "User is Deactivated", null);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/activateUser/{id}")
	private ResponseEntity<Response> activateUser(@PathVariable("id") int id) {
		
		userService.activateUser(id);
		response = utility.buildResponse(true, "User is Activated", null);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/resetPassword")
	private ResponseEntity<Response> resetPassword(@RequestBody UserData data) {
		
		int resetUser = data.getUserId();
		
		String defaultPass = "paymatixHexa2022";
		String encryptedPass = crypt.encrypt(defaultPass);
		
		userService.resetPassword(resetUser, encryptedPass);
		
		response = utility.buildResponse(true, "Password Reset is Successfull", null);
		return ResponseEntity.ok(response);
	}
	
	
}
