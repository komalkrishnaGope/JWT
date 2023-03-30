package com.harvis.paymatix.beans;

import java.util.ArrayList;
import java.util.List;

public class RolesUserId {
	
	private List <Roles> roles = new ArrayList<>();

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

}
