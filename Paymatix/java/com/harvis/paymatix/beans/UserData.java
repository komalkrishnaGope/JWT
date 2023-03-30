package com.harvis.paymatix.beans;

import java.util.ArrayList;
import java.util.List;

public class UserData {

	private int userId;
	private String username;
	private String password;
	private String userEmail;
	private List <Roles> roles = new ArrayList<>();
	
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * @return the roles
	 */
	public List<Roles> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

	/**
	 * @param userId
	 * @param username
	 * @param password
	 * @param userEmail
	 * @param roles
	 */
	public UserData(int userId, String username, String password, String userEmail, List<Roles> roles) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.userEmail = userEmail;
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserData [userId=" + userId + ", username=" + username + ", password=" + password + ", userEmail="
				+ userEmail + ", roles=" + roles + "]";
	}

	public UserData() {
		
	}
	
}
