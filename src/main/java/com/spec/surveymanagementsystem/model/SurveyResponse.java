package com.spec.surveymanagementsystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "survey_response")
public class SurveyResponse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "survey_id")
	private Survey survey;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	private String email;

	@ManyToOne
	@JoinColumn(name = "question_id")
	private SurveyQuestion question;

	private String answer;
	private String status;
	private String createdAt;
	private String updatedAt;

	// Getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public SurveyQuestion getQuestion() {
		return question;
	}

	public void setQuestion(SurveyQuestion question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
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


	public SurveyResponse(Long id, Survey survey, User user, String email, SurveyQuestion question, String answer,
			String status, String createdAt, String updatedAt) {
		super();
		this.id = id;
		this.survey = survey;
		this.user = user;
		this.email = email;
		this.question = question;
		this.answer = answer;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public SurveyResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

}