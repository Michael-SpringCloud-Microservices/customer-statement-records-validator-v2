/**
 * 
 */
package com.michael.customer.statement.validation.exception;

import java.util.Date;

/**
 * @author Michael Philomin Raj
 *
 */
public class ExceptionResponse {
	
	private Date timestamp;
	private String message;
	private String details;
	
	
	/**
	 * @param timestamp
	 * @param message
	 * @param details
	 */
	public ExceptionResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	/**
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ExceptiontResponse [timestamp=" + timestamp + ", message="
				+ message + ", details=" + details + "]";
	}
}
