package com.juniorsilvacc.logistics.controllers.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.juniorsilvacc.logistics.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandle {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFoundExceptionEntity(ObjectNotFoundException ex,
			HttpServletRequest request) {
		
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				"Object Not Found", ex.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}

}
