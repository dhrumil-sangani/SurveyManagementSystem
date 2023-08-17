package com.dev.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "survey_questions")
public class SurveyQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "survey_id")
	private Survey survey;

	private String questionType;
	private String questionTitle;
	private String status;
	private boolean isRequired;
	private String createdAt;
	private String updatedAt;

	@OneToMany(mappedBy = "question")
	private Set<SurveyOption> options;
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

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isRequired() {
		return isRequired;
	}

	public void setRequired(boolean isRequired) {
		this.isRequired = isRequired;
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

	public Set<SurveyOption> getOptions() {
		return options;
	}

	public void setOptions(Set<SurveyOption> options) {
		this.options = options;
	}

	public SurveyQuestion(Long id, Survey survey, String questionType, String questionTitle, String status,
			boolean isRequired, String createdAt, String updatedAt, Set<SurveyOption> options) {
		super();
		this.id = id;
		this.survey = survey;
		this.questionType = questionType;
		this.questionTitle = questionTitle;
		this.status = status;
		this.isRequired = isRequired;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.options = options;
	}

	public SurveyQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}


}
