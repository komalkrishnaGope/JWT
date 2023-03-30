package com.harvis.paymatix.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
	private int adminId;
	
	@Column(columnDefinition = "VARCHAR(25)", unique = true)
	private String userName;
	
	@Column(columnDefinition = "VARCHAR(255)", nullable = false)
	private String password;
	
	@Column(columnDefinition = "VARCHAR(100)", unique = true)
	private String adminEmailId;
	
	
	@Column
	private Date createdDate;
	
	@Column
	private Date modifidDate;

	/**
	 * @return the adminId
	 */
	public int getAdminId() {
		return adminId;
	}

	/**
	 * @param adminId the adminId to set
	 */
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	 * @return the adminEmailId
	 */
	public String getAdminEmailId() {
		return adminEmailId;
	}

	/**
	 * @param adminEmailId the adminEmailId to set
	 */
	public void setAdminEmailId(String adminEmailId) {
		this.adminEmailId = adminEmailId;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the modifidDate
	 */
	public Date getModifidDate() {
		return modifidDate;
	}

	/**
	 * @param modifidDate the modifidDate to set
	 */
	public void setModifidDate(Date modifidDate) {
		this.modifidDate = modifidDate;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", userName=" + userName + ", password=" + password + ", adminEmailId="
				+ adminEmailId + ", createdDate=" + createdDate + ", modifidDate=" + modifidDate + "]";
	}

	/**
	 * @param adminId
	 * @param userName
	 * @param password
	 * @param adminEmailId
	 * @param createdDate
	 * @param modifidDate
	 */
	public Admin(int adminId, String userName, String password, String adminEmailId, Date createdDate,
			Date modifidDate) {
		super();
		this.adminId = adminId;
		this.userName = userName;
		this.password = password;
		this.adminEmailId = adminEmailId;
		this.createdDate = createdDate;
		this.modifidDate = modifidDate;
	}

	/**
	 * 
	 */
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

}
