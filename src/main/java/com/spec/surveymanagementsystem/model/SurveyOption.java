package com.spec.surveymanagementsystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "survey_options")
public class SurveyOption {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "question_id")
	private SurveyQuestion question;

	private String optionText;
	private String createdAt;
	private String updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SurveyQuestion getQuestion() {
		return question;
	}

	public void setQuestion(SurveyQuestion question) {
		this.question = question;
	}

	public String getOptionText() {
		return optionText;
	}

	public void setOptionText(String optionText) {
		this.optionText = optionText;
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

	public SurveyOption(Long id, SurveyQuestion question, String optionText, String createdAt, String updatedAt) {
		super();
		this.id = id;
		this.question = question;
		this.optionText = optionText;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public SurveyOption() {
		super();

	}

}