package com.spec.surveymanagementsystem.dto;

public class RoleCreateRequest{
	private String roleName;
    private boolean status;
    
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
    
    
}
