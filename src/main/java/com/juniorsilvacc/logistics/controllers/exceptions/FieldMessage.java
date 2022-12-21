package com.juniorsilvacc.logistics.controllers.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldMessage {
	
	private String fieldName;
	
	private String message;
	
	public FieldMessage() {
		super();
	}
	
	public FieldMessage(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}
	
}
