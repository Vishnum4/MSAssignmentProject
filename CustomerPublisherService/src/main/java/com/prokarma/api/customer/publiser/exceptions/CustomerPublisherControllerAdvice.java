package com.prokarma.api.customer.publiser.exceptions;

import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.security.sasl.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;

import com.prokarma.api.customer.publiser.domain.ErrorResponse;
import com.prokarma.api.customer.publiser.util.PublisherConstants;

@ControllerAdvice
public class CustomerPublisherControllerAdvice {

	@ExceptionHandler(ServletRequestBindingException.class)
	public final ResponseEntity<ErrorResponse> exception(ServletRequestBindingException ex,
			HttpServletRequest request) {
		ErrorResponse response = new ErrorResponse();
		response.setStatus(PublisherConstants.Error);
		response.setMessage("Request Headers are missing " + ex.getMessage());
		response.errorType(ServletRequestBindingException.class.getSimpleName());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public final ResponseEntity<ErrorResponse> exception(NoHandlerFoundException ex,
			HttpServletRequest request) {
		ErrorResponse response = new ErrorResponse();
		response.setStatus(PublisherConstants.Error);
		response.setMessage("No url " + ex.getMessage());
		response.errorType(NoHandlerFoundException.class.getSimpleName());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(AuthenticationException.class)
	public final ResponseEntity<ErrorResponse> exception(AuthenticationException ex,
			HttpServletRequest request) {
		ErrorResponse response = new ErrorResponse();
		response.setStatus(PublisherConstants.Error);
		response.setMessage("Authentication Issue " + ex.getMessage());
		response.errorType(AuthenticationException.class.getSimpleName());
		return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);

	}

	@ExceptionHandler(GeneralException.class)
	public final ResponseEntity<ErrorResponse> exception(GeneralException ex,
			HttpServletRequest request) {
		ErrorResponse response = new ErrorResponse();
		response.setStatus(PublisherConstants.Error);
		response.setMessage("Request Headers are missing " + ex.getMessage());
		response.errorType(GeneralException.class.getSimpleName());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@ExceptionHandler(ValidationException.class)
	public final ResponseEntity<ErrorResponse> exception(ValidationException ex,
			HttpServletRequest request) {
		ErrorResponse response = new ErrorResponse();
		response.setStatus(PublisherConstants.Error);
		response.setMessage("Input validation error " + ex.getMessage());
		response.errorType(ServletRequestBindingException.class.getSimpleName());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

	}
	
	  @ExceptionHandler(HttpMediaTypeNotSupportedException.class) public final
	  ResponseEntity<ErrorResponse> exception(HttpMediaTypeNotSupportedException
	  ex, HttpServletRequest request) { ErrorResponse response = new
	  ErrorResponse(); response.setStatus(PublisherConstants.Error);
	  response.setMessage("MediaType Not Supported" + ex.getMessage());
	  response.errorType(HttpMediaTypeNotSupportedException.class.getSimpleName());
	  return new ResponseEntity<>(response, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	  
	  }
	  @ExceptionHandler(HttpMessageNotReadableException.class) public final
	  ResponseEntity<ErrorResponse> exception(HttpMessageNotReadableException
	  ex, HttpServletRequest request) { ErrorResponse response = new
	  ErrorResponse(); response.setStatus(PublisherConstants.Error);
	  response.setMessage("Input details are not reable" + ex.getMessage());
	  response.errorType(HttpMessageNotReadableException.class.getSimpleName());
	  return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	  
	  }
	 
}
