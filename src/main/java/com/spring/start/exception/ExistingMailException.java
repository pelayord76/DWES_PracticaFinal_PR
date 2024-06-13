package com.spring.start.exception;

public class ExistingMailException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8400936544209967217L;

	public ExistingMailException(String errorMsg) {
		super(errorMsg);
	}
}
