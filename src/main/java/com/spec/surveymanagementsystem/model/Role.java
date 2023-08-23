package com.spec.surveymanagementsystem.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String status;

	@ManyToMany(mappedBy = "roles")
	private Set<User> users;
	public Role() {
		super();
		
	}

	public Long getId() {
		return id;
	}
	// Getters and setters, constructors, other fields
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Role(Long id, String name, String status, Set<User> users) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.users = users;
	}
}
