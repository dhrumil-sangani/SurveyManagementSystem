package com.spec.surveymanagementsystem.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class QuestionDTO {

	@NotBlank
	private String title;

	@NotBlank
	private String type;

	@NotNull
	private boolean required;

	private List<String> options;

	// Constructors, getters, setters
	
	

	public List<String> getOptions() {
		return options;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}
}
