package com.spec.surveymanagementsystem.model;

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
	@JoinColumn(name = "created_by")
	private User createdByUser;

	@ManyToOne
	@JoinColumn(name = "updated_by")
	private User updatedByUser;

	private String title;
	private String descriptions;
	private String start_date;
	private String expiration_date;
	private String status;
	private String survey_link;

	@OneToMany(mappedBy = "survey")
	private Set<SurveyQuestion> surveyQuestions;

	public Survey(Long id, Organization organization, User createdByUser, String title, String descriptions,
			String start_date, String expiration_date, String status, String survey_link,
			Set<SurveyQuestion> surveyQuestions) {
		super();
		this.id = id;
		this.organization = organization;
		this.createdByUser = createdByUser;
		this.title = title;
		this.descriptions = descriptions;
		this.start_date = start_date;
		this.expiration_date = expiration_date;
		this.status = status;
		this.survey_link = survey_link;
		this.surveyQuestions = surveyQuestions;
	}

	public Survey() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public User getUpdatedByUser() {
		return updatedByUser;
	}

	public void setUpdatedByUser(User updatedByUser) {
		this.updatedByUser = updatedByUser;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(String expiration_date) {
		this.expiration_date = expiration_date;
	}

	public String getSurvey_link() {
		return survey_link;
	}

	public void setSurvey_link(String survey_link) {
		this.survey_link = survey_link;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<SurveyQuestion> getSurveyQuestions() {
		return surveyQuestions;
	}

	public void setSurveyQuestions(Set<SurveyQuestion> surveyQuestions) {
		this.surveyQuestions = surveyQuestions;
	}

}