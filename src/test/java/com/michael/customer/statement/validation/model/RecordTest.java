/**
 * 
 */
package com.michael.customer.statement.validation.model;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Michael Philomin Raj
 *
 */
@RunWith(SpringRunner.class)
public class RecordTest {
	
	@Test
	public void testRecord(){
		Record record = new Record();
		record.setReference("177666");
		record.setAccountNumber("NL93ABNA0585619023");
		record.setDescription("Flowers for Rik Theuß");
		record.setStartBalance("44.85");
		record.setMutation("-22.24");
		record.setEndBalance("22.61");
		
		Assert.assertNotEquals(null, record);
		Assert.assertNotEquals(null, record.toString());
		assertEquals("177666", record.getReference());
		assertEquals("NL93ABNA0585619023", record.getAccountNumber());
		assertEquals("Flowers for Rik Theuß", record.getDescription());
		assertEquals("44.85", record.getStartBalance());
		assertEquals("-22.24", record.getMutation());
		assertEquals("22.61", record.getEndBalance());

	}

}
