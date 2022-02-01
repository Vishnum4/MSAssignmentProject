package com.prokarma.api.customer.publiser.exceptions;

import org.springframework.stereotype.Component;

@Component
public class GeneralException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4857938195844438210L;

	public GeneralException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GeneralException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public GeneralException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public GeneralException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public GeneralException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	

}
