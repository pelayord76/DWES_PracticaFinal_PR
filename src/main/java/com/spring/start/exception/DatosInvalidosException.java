package com.spring.start.exception;

public class DatosInvalidosException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8400936544209967217L;

	public DatosInvalidosException(String errorMsg) {
		super(errorMsg);
	}
}
