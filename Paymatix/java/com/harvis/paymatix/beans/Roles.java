package com.harvis.paymatix.beans;

public class Roles {
	
	private int roleId;

	/**
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "Roles [roleId=" + roleId + "]";
	}

	/**
	 * @param roleId
	 */
	public Roles(int roleId) {
		super();
		this.roleId = roleId;
	}
	
	public Roles() {
		
	}

}
