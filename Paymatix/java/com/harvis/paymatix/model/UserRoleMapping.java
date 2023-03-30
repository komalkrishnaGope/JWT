package com.harvis.paymatix.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "userrolemapping")
public class UserRoleMapping {

	@OneToOne
	private Users user;
	
	@OneToOne
	private Roles role;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int userRoleId;

	/**
	 * @return the user
	 */
	public Users getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(Users user) {
		this.user = user;
	}

	/**
	 * @return the role
	 */
	public Roles getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Roles role) {
		this.role = role;
	}

	/**
	 * @return the userRoleId
	 */
	public int getUserRoleId() {
		return userRoleId;
	}

	/**
	 * @param userRoleId the userRoleId to set
	 */
	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	@Override
	public String toString() {
		return "UserRoleMapping [user=" + user + ", role=" + role + ", userRoleId=" + userRoleId + "]";
	}
	
	/**
	 * @param user
	 * @param role
	 * @param userRoleId
	 */
	public UserRoleMapping(Users user, Roles role, int userRoleId) {
		super();
		this.user = user;
		this.role = role;
		this.userRoleId = userRoleId;
	}

	/**
	 * 
	 */
	public UserRoleMapping() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
