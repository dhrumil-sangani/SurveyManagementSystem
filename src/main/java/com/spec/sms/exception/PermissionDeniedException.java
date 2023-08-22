package com.spec.sms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class PermissionDeniedException extends RuntimeException {

	public PermissionDeniedException(String action) {
		super("Permission denied for action: " + action);
	}
}
