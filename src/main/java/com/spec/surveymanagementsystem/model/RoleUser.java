package com.spec.surveymanagementsystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "role_user")
public class RoleUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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

	public RoleUser(Long id, Role role, User user, String createdAt, String updatedAt) {
		super();
		this.id = id;
		this.role = role;
		this.user = user;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public RoleUser() {
		super();
	
	}


	
	
}
