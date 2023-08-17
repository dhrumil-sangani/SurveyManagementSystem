package com.dev.model;

import jakarta.persistence.*;

@Entity
@Table(name = "survey_assign")
public class SurveyAssign {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "survey_id")
	private Survey survey;

	@ManyToOne
	@JoinColumn(name = "assign_to")
	private User assignTo;

	@ManyToOne
	@JoinColumn(name = "assign_by")
	private User assignBy;

	private String status;
	private boolean isDeleted;
	private String createdAt;
	private String updatedAt;

	public Long getId() {
		return id;
	}

	// Getters and setters
	
	public void setId(Long id) {
		this.id = id;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public User getAssignTo() {
		return assignTo;
	}

	public void setAssignTo(User assignTo) {
		this.assignTo = assignTo;
	}

	public User getAssignBy() {
		return assignBy;
	}

	public void setAssignBy(User assignBy) {
		this.assignBy = assignBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
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

	public SurveyAssign(Long id, Survey survey, User assignTo, User assignBy, String status, boolean isDeleted,
			String createdAt, String updatedAt) {
		super();
		this.id = id;
		this.survey = survey;
		this.assignTo = assignTo;
		this.assignBy = assignBy;
		this.status = status;
		this.isDeleted = isDeleted;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public SurveyAssign() {
		super();

	}

}