package com.spec.surveymanagementsystem.dto;

public class PermissionCreateRequest  {
	private String permissionName;
	private boolean status;
	
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
