package com.michael.customer.statement.validation.model;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author Michael Philomin Raj
 *
 */
public class Record
{
	private String reference;

	private String accountNumber;

	private String description;

	private String startBalance;

	private String mutation;

	private String endBalance;


	public String getReference ()
	{
		return reference;
	}

	@XmlAttribute(name = "reference")
	public void setReference (String reference)
	{
		this.reference = reference;
	}

	public String getAccountNumber ()
	{
		return accountNumber;
	}

	public void setAccountNumber (String accountNumber)
	{
		this.accountNumber = accountNumber;
	}

	public String getDescription ()
	{
		return description;
	}

	public void setDescription (String description)
	{
		this.description = description;
	}



	public String getStartBalance ()
	{
		return startBalance;
	}

	public void setStartBalance (String startBalance)
	{
		this.startBalance = startBalance;
	}

	public String getMutation ()
	{
		return mutation;
	}

	public void setMutation (String mutation)
	{
		this.mutation = mutation;
	}

	public String getEndBalance ()
	{
		return endBalance;
	}

	public void setEndBalance (String endBalance)
	{
		this.endBalance = endBalance;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Record [reference=" + reference + ", accountNumber="
				+ accountNumber + ", description=" + description
				+ ", startBalance=" + startBalance + ", mutation=" + mutation
				+ ", endBalance=" + endBalance + "]";
	}	

}
