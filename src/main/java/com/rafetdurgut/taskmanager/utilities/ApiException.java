package com.rafetdurgut.taskmanager.utilities;

public class ApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;
	private int code;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public ApiException(String message, int code) {
		this.message = message;
		this.code = code;
	}
	
	

}
