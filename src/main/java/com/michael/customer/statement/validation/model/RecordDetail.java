package com.michael.customer.statement.validation.model;

/**
 * @author Michael Philomin Raj
 *
 */
public class RecordDetail {

	private long reference;
	private String accountNumber;
	private String description;
	private double startBalance;
	private double mutation;
	private double endBalance;
	private boolean isValid;

	public long getReference() {
		return reference;
	}

	public RecordDetail setReference(long reference) {
		this.reference = reference;
		return this;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public RecordDetail setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public RecordDetail setDescription(String description) {
		this.description = description;
		return this;
	}

	public double getStartBalance() {
		return startBalance;
	}

	public RecordDetail setStartBalance(double startBalance) {
		this.startBalance = startBalance;
		return this;
	}

	public double getMutation() {
		return mutation;
	}

	public RecordDetail setMutation(double mutation) {
		this.mutation = mutation;
		return this;
	}

	public double getEndBalance() {
		return endBalance;
	}

	public RecordDetail setEndBalance(double endBalance) {
		this.endBalance = endBalance;
		return this;
	}

	public boolean isValid() {
		return isValid;
	}

	public RecordDetail setValid(boolean valid) {
		isValid = valid;
		return this;
	}

	public Report convertToReport(){
		Report report = new Report();
		report.setTransactionReference(String.valueOf(this.reference));
		report.setDescription(this.description);
		return report;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("RecordDetail{");
		sb.append("reference=").append(reference);
		sb.append(", accountNumber='").append(accountNumber).append('\'');
		sb.append(", description='").append(description).append('\'');
		sb.append(", startBalance=").append(startBalance);
		sb.append(", mutation=").append(mutation);
		sb.append(", endBalance=").append(endBalance);
		sb.append(", isValid=").append(isValid);
		sb.append('}');
		return sb.toString();
	}
}
