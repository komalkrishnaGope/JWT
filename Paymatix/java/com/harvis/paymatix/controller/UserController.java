package com.harvis.paymatix.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RestController;
import com.harvis.paymatix.beans.PasswordEncrypt;
import com.harvis.paymatix.dto.UserResponse;
import com.harvis.paymatix.model.Roles;
import com.harvis.paymatix.model.UserRoleMapping;
import com.harvis.paymatix.model.Users;
import com.harvis.paymatix.response.AuthResponse;
import com.harvis.paymatix.response.Response;
//import com.harvis.paymatix.security.JwtUtils;
import com.harvis.paymatix.jwt.JWTUtils;
import com.harvis.paymatix.service.UserRoleMappingService;
import com.harvis.paymatix.service.UserService;
import com.harvis.paymatix.utility.CommonUtility;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin
@RequestMapping("/paymatix")
public class UserController {
	 
	@Autowired
	UserService userService;
	
	@Autowired
	UserRoleMappingService userRoleMappingService;
	
	@Autowired
	JWTUtils jwtUtils;
	
	@Autowired
	AuthenticationManager authenicationManager;
	
	// getting all the active user
	@GetMapping("/users")  
	private ResponseEntity<Response> getusers() {
		CommonUtility utility = new CommonUtility();
		Iterable <Users> users = userService.getAllusers();
		List<UserResponse> allUsers = utility.getUsersInfo(users);
		List<Roles> roles;
		
		for(UserResponse userDetail:allUsers) {
			List<UserRoleMapping> userRoleMappings = userRoleMappingService.getUserRoleMappingById(userDetail.getUserId());
			roles = new ArrayList<>();
			for(UserRoleMapping userRole :userRoleMappings) {
				if(userDetail.getUserId() == userRole.getUser().getUserId()) {
					Roles role = new Roles();
					role.setRoleId(userRole.getRole().getRoleId());
					role.setRoleName(userRole.getRole().getRoleName());
					roles.add(role);
					userDetail.setRoles(roles);
				}
			}
		}
		return ResponseEntity.ok(utility.buildResponse(Boolean.TRUE, "Total Users info", allUsers));
	}
	
	@PostMapping("/login")
	private ResponseEntity<AuthResponse> login(@RequestBody Users user){
		CommonUtility utility = new CommonUtility();
		Optional<Users> userDetails = userService.userCheck(user.getUserName());
		
		PasswordEncrypt crypt = new PasswordEncrypt();
		AuthResponse authResponse;
		
		if(!userDetails.isPresent()) {
			authResponse = utility.buildAuthResponse(Boolean.FALSE, "Check up the username",null, null);
			return ResponseEntity.ok(authResponse);
		}
		
		if(userDetails.get() != null && !userDetails.get().getIsActive()) {
			authResponse = utility.buildAuthResponse(Boolean.FALSE, "User deactivated", null,null);
			return ResponseEntity.ok(authResponse);
		}
		
		String enteredpassword = user.getPassword();
		String encryptedpass = userDetails.get().getPassword();
		String dbPassword = crypt.decrypt(encryptedpass);
		
		if(!enteredpassword.equals(dbPassword)) {
			authResponse = utility.buildAuthResponse(Boolean.FALSE, "Your Password is Wrong", null,null);
			return ResponseEntity.ok(authResponse);
		}
		
		UserResponse userData = utility.getUserData(userDetails);
		
//		JwtUtils jwtUtils = new JwtUtils();
//		String token = jwtUtils.generateJwtToken(userData);
		
		String token = jwtUtils.generateToken(user.getUserName());
		
		if(token == null) {
			authResponse = utility.buildAuthResponse(Boolean.FALSE, "Token not generated. please check", token, userData);
			return ResponseEntity.ok(authResponse);
		}
		
		authResponse = utility.buildAuthResponse(Boolean.TRUE, "Login Successfully", token, userData);
		return ResponseEntity.ok(authResponse);
	}
	
}
