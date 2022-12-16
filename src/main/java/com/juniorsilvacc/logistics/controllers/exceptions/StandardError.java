package com.juniorsilvacc.logistics.controllers.exceptions;

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

	public Long getTimesamp() {
		return timesamp;
	}

	public void setTimesamp(Long timesamp) {
		this.timesamp = timesamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessager() {
		return messager;
	}

	public void setMessager(String messager) {
		this.messager = messager;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
