package com.michael.customer.statement.validation.exception;


import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/**
 * @author Michael Philomin Raj
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedFileFormatException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnsupportedFileFormatException(String message) {
		super(message);
	}
}
