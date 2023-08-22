package com.spec.sms.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "surveys")
public class Survey {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "organization_id")
	private Organization organization;

	@ManyToOne
	@JoinColumn(name = "created_by_user_id")
	private User createdByUser;

	private String title;
	private String descriptions;
	private String startDate;
	private String expirationDate;
	private String status;
	private String surveyLink;
	private String createdAt;
	private String updatedAt;

	@OneToMany(mappedBy = "survey")
	private Set<SurveyQuestion> surveyQuestions;

	public Long getId() {
		return id;
	}

	// Getters and setters

	public void setId(Long id) {
		this.id = id;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public User getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(User createdByUser) {
		this.createdByUser = createdByUser;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSurveyLink() {
		return surveyLink;
	}

	public void setSurveyLink(String surveyLink) {
		this.surveyLink = surveyLink;
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

	public Set<SurveyQuestion> getSurveyQuestions() {
		return surveyQuestions;
	}

	public void setSurveyQuestions(Set<SurveyQuestion> surveyQuestions) {
		this.surveyQuestions = surveyQuestions;
	}

	public Survey(Long id, Organization organization, User createdByUser, String title, String descriptions,
			String startDate, String expirationDate, String status, String surveyLink, String createdAt,
			String updatedAt, Set<SurveyQuestion> surveyQuestions) {
		super();
		this.id = id;
		this.organization = organization;
		this.createdByUser = createdByUser;
		this.title = title;
		this.descriptions = descriptions;
		this.startDate = startDate;
		this.expirationDate = expirationDate;
		this.status = status;
		this.surveyLink = surveyLink;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.surveyQuestions = surveyQuestions;
	}

	public Survey() {
		super();
		// TODO Auto-generated constructor stub
	}

}