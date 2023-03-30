package com.harvis.paymatix.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "roleactionmapping")
public class RoleActionMapping {
	
	@OneToOne
	private Roles role;
	
	@OneToOne
	private Actions action;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int roleActionId;

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
	 * @return the action
	 */
	public Actions getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(Actions action) {
		this.action = action;
	}

	/**
	 * @return the roleActionId
	 */
	public int getRoleActionId() {
		return roleActionId;
	}

	/**
	 * @param roleActionId the roleActionId to set
	 */
	public void setRoleActionId(int roleActionId) {
		this.roleActionId = roleActionId;
	}
	
	@Override
	public String toString() {
		return "RoleActionMapping [role=" + role + ", action=" + action + ", roleActionId=" + roleActionId + "]";
	}

	
	/**
	 * @param role
	 * @param action
	 * @param roleActionId
	 */
	public RoleActionMapping(Roles role, Actions action, int roleActionId) {
		super();
		this.role = role;
		this.action = action;
		this.roleActionId = roleActionId;
	}

	/**
	 * 
	 */
	public RoleActionMapping() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
