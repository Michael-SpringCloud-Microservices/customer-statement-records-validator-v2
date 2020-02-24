package com.michael.customer.statement.validation.model;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Michael Philomin Raj
 *
 */
@XmlRootElement(name = "records")
public class Records
{
	private Record[] record;

	public Record[] getRecord ()
	{
		return record;
	}

	@XmlElement(name = "record")
	public void setRecord (Record[] record)
	{
		this.record = record;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Records [record=" + Arrays.toString(record) + "]";
	}    

}
