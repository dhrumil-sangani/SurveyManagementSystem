package com.spec.surveymanagementsystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Date;

/**
 * The organization modal.
 *
 * @author : SPEC Developer on 23/08/2023.
 */
@Entity
@Table(name = "organizations")
public class Organization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// The name of the organization, required and with size constraints
	@NotNull
	@Size(min = 1, max = 100)
	private String name;

	// The description of the organization, not nullable
	@Size(min = 4, max = 500)
	@Column(name = "description", nullable = false)
	private String description;

	// The status of the organization
	@Column(name = "status", nullable = false)
	private boolean status;

	// The timestamp when the organization was created
	@Column(name = "created_at")
	private Date createdAt;

	// The user ID of the creator
	@Column(name = "created_by")
	private Long createdBy;

	// The timestamp when the organization was last updated
	@Column(name = "updated_at")
	private Date updatedAt;

	// The user ID of the last user who updated the organization
	@Column(name = "updated_by")
	private Long updatedBy;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

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
	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Organization() {
		super();
	}

}