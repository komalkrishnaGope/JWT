package com.harvis.paymatix.dto;

import java.util.List;

public class UserInfo {
	
	private String userName;
	private String email;
	private Boolean isActive;
	private List<RoleActionInfo> actions;
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Boolean getIsActive() {
		return isActive;
	}
	
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	public List<RoleActionInfo> getActions() {
		return actions;
	}
	
	public void setActions(List<RoleActionInfo> actions) {
		this.actions = actions;
	}
	
}
