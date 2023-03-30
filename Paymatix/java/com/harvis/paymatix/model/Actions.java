package com.harvis.paymatix.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "actions")
public class Actions {

	@ManyToOne
	private Actions reference;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int actionId; 
	
	@Column(columnDefinition = "VARCHAR(100)", unique = true)
	private String acionName;
	
	@Column(columnDefinition = "VARCHAR(10)", nullable = false)
    private String category;
	
	@Column(columnDefinition = "VARCHAR(255)")
	private String url;
	
	@Column(columnDefinition = "VARCHAR(255)")
	private String icon;

	/**
	 * @return the reference
	 */
	public Actions getReference() {
		return reference;
	}

	/**
	 * @param reference the reference to set
	 */
	public void setReference(Actions reference) {
		this.reference = reference;
	}

	/**
	 * @return the actionId
	 */
	

	/**
	 * @return the acionName
	 */
	public String getAcionName() {
		return acionName;
	}

	/**
	 * @return the actionId
	 */
	public int getActionId() {
		return actionId;
	}

	/**
	 * @param actionId the actionId to set
	 */
	public void setActionId(int actionId) {
		this.actionId = actionId;
	}

	/**
	 * @param acionName the acionName to set
	 */
	public void setAcionName(String acionName) {
		this.acionName = acionName;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
	public String toString() {
		return "Action [reference=" + reference + ", actionId=" + actionId + ", acionName=" + acionName + ", category="
				+ category + ", url=" + url + ", icon=" + icon + "]";
	}

	
	/**
	 * @param reference
	 * @param actionId
	 * @param acionName
	 * @param category
	 * @param url
	 * @param icon
	 */
	public Actions(Actions reference, int actionId, String acionName, String category, String url, String icon) {
		super();
		this.reference = reference;
		this.actionId = actionId;
		this.acionName = acionName;
		this.category = category;
		this.url = url;
		this.icon = icon;
	}

	/**
	 * 
	 */
	public Actions() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
