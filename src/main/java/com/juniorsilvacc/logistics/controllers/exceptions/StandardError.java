package com.juniorsilvacc.logistics.controllers.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StandardError {
	
	private Long timesamp;
	private Integer status;
	private String error;
	private String messager;
	private String path;
	
	public StandardError() {
		super();
	}

	public StandardError(Long timesamp, Integer status, String error, String messager, String path) {
		super();
		this.timesamp = timesamp;
		this.status = status;
		this.error = error;
		this.messager = messager;
		this.path = path;
	}

}
