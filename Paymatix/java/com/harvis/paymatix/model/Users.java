package com.harvis.paymatix.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
	private int userId;
	
	@Column(columnDefinition = "VARCHAR(25)", unique = true)
	private String userName;
	
	@Column(columnDefinition = "VARCHAR(255)", nullable = false)
	private String password;
	
	@Column(columnDefinition = "VARCHAR(100)", unique = true)
	private String email;
	
	@Column(columnDefinition = "DATE")
	private Date createdOn;
	
	@Column
	private Date modifiedDate;
	
	@Column
	private Boolean isActive;

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

	public String getUserName() {
		return userName;
	}

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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the modifiedDate
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(createdOn, email, isActive, modifiedDate, password, userId, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(createdOn, other.createdOn) && Objects.equals(email, other.email)
				&& Objects.equals(isActive, other.isActive) && Objects.equals(modifiedDate, other.modifiedDate)
				&& Objects.equals(password, other.password) && userId == other.userId
				&& Objects.equals(userName, other.userName);
	}
	

	
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", createdOn=" + createdOn + ", modifiedDate=" + modifiedDate + ", isActive=" + isActive + "]";
	}
	
	/**
	 * @param userId
	 * @param userName
	 * @param password
	 * @param email
	 * @param createdOn
	 * @param modifiedDate
	 * @param isActive
	 */
	public Users(int userId, String userName, String password, String email, Date createdOn, Date modifiedDate,
			Boolean isActive) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.createdOn = createdOn;
		this.modifiedDate = modifiedDate;
		this.isActive = isActive;
	}

	/**
	 * 
	 */
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

}
