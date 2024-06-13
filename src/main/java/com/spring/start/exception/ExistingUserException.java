package com.spring.start.exception;

public class ExistingUserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8400936544209967217L;

	public ExistingUserException(String errorMsg) {
		super(errorMsg);
	}
}
