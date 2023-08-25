package com.spec.surveymanagementsystem.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import jakarta.validation.constraints.Size;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class OrganizationDto {

    private Long id; // Unique identifier for the organization
    @NotNull
    @Size(min = 1, max = 100)
    private String name; // Name of the organization
    @Size(min = 4, max = 500)
    private String description; // Name of the organization
    /**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	private boolean status; // Status of the organization
    private LocalDateTime createdAt; // Date and time when the organization was created
    private String createdBy; // User who created the organization
    private LocalDateTime updatedAt; // Date and time when the organization was last updated
    private String updatedBy; // User who last updated the organization

    // Constructors, getters, and setters
    // You can generate these using your IDE or manually implement them.

    // Default constructor
    public OrganizationDto() {
        // Default constructor
    }

    // Parameterized constructor to initialize all fields
    public OrganizationDto(Long id, String name, boolean status, LocalDateTime createdAt,
                           String createdBy, LocalDateTime updatedAt, String updatedBy) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }

    // Getters and setters for fields

    // Getter for id
    public Long getId() {
        return id;
    }

    // Setter for id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for status
    public boolean getStatus() {
        return status;
    }

    // Setter for status
    public void setStatus(boolean status) {
        this.status = status;
    }

    // Getter for createdAt
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Setter for createdAt
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // Getter for createdBy
    public String getCreatedBy() {
        return createdBy;
    }

    // Setter for createdBy
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    // Getter for updatedAt
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    // Setter for updatedAt
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    // Getter for updatedBy
    public String getUpdatedBy() {
        return updatedBy;
    }

    // Setter for updatedBy
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
