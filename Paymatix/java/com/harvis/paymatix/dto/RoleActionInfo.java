package com.harvis.paymatix.dto;

import java.util.ArrayList;
import java.util.Objects;

public class RoleActionInfo {
	
	private String actionName;
	private String icon;
	private ArrayList<SubMenuInfo> submenu;
	
	public String getActionName() {
		return actionName;
	}
	
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	
	public String getIcon() {
		return icon;
	}
	
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public ArrayList<SubMenuInfo> getSubmenu() {
		return submenu;
	}
	
	public void setSubmenu(ArrayList<SubMenuInfo> submenu) {
		this.submenu = submenu;
	}

	@Override
	public int hashCode() {
		return Objects.hash(actionName, icon, submenu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoleActionInfo other = (RoleActionInfo) obj;
		return Objects.equals(actionName, other.actionName) && Objects.equals(icon, other.icon)
				&& Objects.equals(submenu, other.submenu);
	}
	
}
