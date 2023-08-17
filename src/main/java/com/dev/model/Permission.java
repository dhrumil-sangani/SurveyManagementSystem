package com.dev.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tbl_permissions")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String status;
    private String createdAt;
    private String updatedAt;

    @ManyToMany(mappedBy = "permissions")
    private Set<PermissionsRole> roles;

	public Long getId() {
		return id;
	}
	
    // Getters and setters
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Set<PermissionsRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<PermissionsRole> roles) {
		this.roles = roles;
	}

	public Permission(Long id, String title, String status, String createdAt, String updatedAt,
			Set<PermissionsRole> roles) {
		super();
		this.id = id;
		this.title = title;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.roles = roles;
	}

	public Permission() {
		super();
		
	}


    
    
}