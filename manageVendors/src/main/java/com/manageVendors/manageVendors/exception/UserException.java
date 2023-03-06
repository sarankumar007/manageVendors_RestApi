package com.manageVendors.manageVendors.exception;

public class UserException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String status;
	private String message;

	public UserException(String status, String message) {
		super(message);
		this.status = status;
		this.message = message;
	}

	public String getStatus() {
		return this.status;
	}

	public String getMessage() {
		return this.message;
	}
}
