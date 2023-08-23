package com.spec.surveymanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SurveyNotFoundException extends RuntimeException {

	public SurveyNotFoundException(Long surveyId) {
		super("Survey with ID " + surveyId + " not found");
	}
}
