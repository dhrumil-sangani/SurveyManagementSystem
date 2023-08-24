package com.spec.surveymanagementsystem.dto;

public class PermissionCreateRequest  {
	private String permissionName;
	private String status;
	
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
