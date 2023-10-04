package com.spec.osm.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class SurveyException extends Throwable {

    private final String message;
    private final Throwable throwable;

    private final HttpStatus httpStatus;

}
