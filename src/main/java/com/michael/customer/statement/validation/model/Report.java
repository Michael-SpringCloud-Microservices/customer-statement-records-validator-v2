/**
 * 
 */
package com.michael.customer.statement.validation.model;

/**
 * @author Michael Philomin Raj
 *
 */
public class Report {

	private String transactionReference;

	private String description;

	/**
	 * @return the transactionReference
	 */
	public String getTransactionReference() {
		return transactionReference;
	}

	/**
	 * @param transactionReference the transactionReference to set
	 */
	public Report setTransactionReference(String transactionReference) {
		this.transactionReference = transactionReference;
		return this;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public Report setDescription(String description) {
		this.description = description;
		return this;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Report [transactionReference=" + transactionReference
				+ ", description=" + description + "]";
	}	


}
