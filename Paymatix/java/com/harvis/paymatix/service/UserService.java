package com.harvis.paymatix.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.harvis.paymatix.model.Users;
import com.harvis.paymatix.repository.UserRepository;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserDetails loadUserByUsername(String userName) throws NotFound {
		Optional<Users> data = userRepository.getUserName(userName);
		return new User(data.get().getUserName(), data.get().getPassword(), new ArrayList<>());
	}
	
	public Optional<Users> getUserById(int id) {
		return userRepository.findById(id);
	}
	
	public Iterable <Users> getAllusers() {
		return userRepository.findAll();	
	}
	
	public Optional<Users> userCheck(String Username) {
		return userRepository.findByUserName(Username);
	}
	
	public Optional<Users> emailCheck(String Email) {
		return userRepository.findByEmail(Email);
	}
	
	public void saveUser(Users user) {  
		userRepository.save(user);  
	}
	
	public void editUser(int userId, String email, Date modifiedDate) {
		userRepository.editUser(userId, email, modifiedDate);
	}
	
	public void deactivateUser(int userId) {
		userRepository.deactivateUser(userId);
	}
	
	public void activateUser(int userId) {
		userRepository.activateUser(userId);
	}
	
	public void resetPassword(int userId, String defaultPass) {
		userRepository.resetPassword(userId, defaultPass);
	}
	
}
