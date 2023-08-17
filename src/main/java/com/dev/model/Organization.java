package com.dev.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_organizations")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String status;
    private String createdBy;
    private String updatedBy;

    @OneToMany(mappedBy = "organization")
    private List<User> users;

    @OneToMany(mappedBy = "organization")
    private List<Survey> surveys;

    // Getters and setters, constructors, other fields
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Survey> getSurveys() {
		return surveys;
	}

	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	}

	public Organization(Long id, String name, String description, String status, String createdBy, String updatedBy,
			List<User> users, List<Survey> surveys) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.status = status;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.users = users;
		this.surveys = surveys;
	}

	public Organization() {
		super();
		
	}

	
   
    
    
}