package com.harvis.paymatix.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.harvis.paymatix.model.RoleActionMapping;
import com.harvis.paymatix.model.UserRoleMapping;
import com.harvis.paymatix.model.Admin;
import com.harvis.paymatix.model.Users;
import com.harvis.paymatix.response.AuthResponse;
import com.harvis.paymatix.response.Response;
import com.harvis.paymatix.dto.RoleActionInfo;
import com.harvis.paymatix.dto.SubMenuInfo;
import com.harvis.paymatix.dto.UserResponse;
import com.harvis.paymatix.dto.UserInfo;

public class CommonUtility {
	
	public UserResponse getUserData(Optional<Users> userDetails) {
		
		UserResponse user= new UserResponse();
		
		user.setUserId(userDetails.get().getUserId());
		user.setUserName(userDetails.get().getUserName());
		user.setIsActive(userDetails.get().getIsActive());
		user.setModifiedDate(userDetails.get().getModifiedDate());
		user.setCreatedOn(userDetails.get().getCreatedOn());
		user.setEmail(userDetails.get().getEmail());
		
		return user;
	}
	
	public UserResponse getAdminData(Optional<Admin> adminDetails) {
		
		UserResponse admin = new UserResponse();
		
		admin.setUserId(adminDetails.get().getAdminId());
		admin.setUserName(adminDetails.get().getUserName());
		admin.setEmail(adminDetails.get().getAdminEmailId());
		admin.setCreatedOn(adminDetails.get().getCreatedDate());
		admin.setModifiedDate(adminDetails.get().getModifidDate());
		
		return admin;
	}
	
	public List<UserResponse> getUsersInfo(Iterable <Users> users){
		
		List<UserResponse> userResponse = new ArrayList<>();
		
		for(Users user :users) {
			UserResponse userData = new UserResponse();
			userData.setUserId(user.getUserId());
			userData.setUserName(user.getUserName());
			userData.setEmail(user.getEmail());
			userData.setIsActive(user.getIsActive());
			userData.setModifiedDate(user.getModifiedDate());
			userData.setCreatedOn(user.getCreatedOn());
			userResponse.add(userData);
		}
		
		return userResponse;
	}
	
	public UserInfo getUserInfo(List<UserRoleMapping> userDetails, ArrayList<RoleActionMapping> roleDetails) {
		
		UserInfo users = new UserInfo();
		
		users.setUserName(userDetails.get(0).getUser().getUserName());
		users.setEmail(userDetails.get(0).getUser().getEmail());
		users.setIsActive(userDetails.get(0).getUser().getIsActive());
		users.setActions(getRoleActionInfo(userDetails, roleDetails));
		
		return users;
	}
	
	public ArrayList<RoleActionInfo> getRoleActionInfo(List<UserRoleMapping> userDetails, ArrayList<RoleActionMapping> roleDetails) {
		
		ArrayList<RoleActionInfo> actionInfo = new ArrayList<>();
		
		for(UserRoleMapping userDetail : userDetails) {
			for(RoleActionMapping roleDetail : roleDetails) {
				if(userDetail.getRole().getRoleId() == roleDetail.getRole().getRoleId()) {
					RoleActionInfo setData = new RoleActionInfo();
					setData.setActionName(roleDetail.getAction().getAcionName());
					setData.setIcon(roleDetail.getAction().getIcon());
					actionInfo.add(setData);
				}
			}
		}
		actionInfo = (ArrayList<RoleActionInfo>)actionInfo.stream().distinct().collect(Collectors.toList());
		for(RoleActionInfo action : actionInfo) {
			action.setSubmenu(getSubMenuInfo(action, roleDetails));
		}
		
		return actionInfo;
	}
	
	public ArrayList<SubMenuInfo> getSubMenuInfo(RoleActionInfo action, ArrayList<RoleActionMapping> roleDetails) {
		
		ArrayList<SubMenuInfo> subMenuInfo = new ArrayList<>();
		
		for(RoleActionMapping menu : roleDetails) {
			if(action.getActionName().equalsIgnoreCase(menu.getAction().getAcionName())) {
				SubMenuInfo menuInfo = new SubMenuInfo();
				menuInfo.setActionName(menu.getAction().getAcionName() + " - " + menu.getRole().getRoleName());
				menuInfo.setUrl(menu.getAction().getUrl());
				subMenuInfo.add(menuInfo);
			}
		}	
		
		return subMenuInfo;
	}
	
	public Response buildResponse(boolean status, String message, Object data){
		
		Response response = new Response();
		
		response.setStatus(status);
		response.setMessage(message);
		response.setData(data);
		
		return response;
	}
	
	public AuthResponse buildAuthResponse(boolean status, String message, String token,Object data){
		
		AuthResponse response = new AuthResponse();
		
		response.setStatus(status);
		response.setMessage(message);
		response.setData(data);
		response.setToken(token);
		
		return response;
	}
	
}
