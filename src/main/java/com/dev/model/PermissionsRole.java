package com.dev.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_permissions_role")
public class PermissionsRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

	@ManyToOne
	@JoinColumn(name = "permission_id")
	private Permission permission;

	private String createdAt;
	private String updatedAt;

	public Long getId() {
		return id;
	}

	// Getters and setters

	public void setId(Long id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public PermissionsRole(Long id, Role role, Permission permission, String createdAt, String updatedAt) {
		super();
		this.id = id;
		this.role = role;
		this.permission = permission;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public PermissionsRole() {
		super();

	}

}
