package com.spec.osm.exception;

public class SurveyNotFoundException extends RuntimeException {
    public SurveyNotFoundException(String message) {
        super(message);
    }

    public SurveyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
