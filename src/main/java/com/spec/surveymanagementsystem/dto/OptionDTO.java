package com.spec.surveymanagementsystem.dto;

import javax.validation.constraints.NotBlank;

public class OptionDTO {

	@NotBlank
	private String optionText;

	// Constructors, getters, setters

	public String getOptionText() {
		return optionText;
	}

	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}
}
