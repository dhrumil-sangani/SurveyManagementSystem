package com.spec.osm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SurveyExceptionHandler {
    @ExceptionHandler(value = {SurveyNotFoundException.class})
    public ResponseEntity<SurveyException> handleSurveyNotFoundException(SurveyNotFoundException surveyNotFoundException) {
        SurveyException surveyException = new SurveyException(surveyNotFoundException.getMessage(), surveyNotFoundException.getCause(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(surveyException, HttpStatus.NOT_FOUND);
    }
}
