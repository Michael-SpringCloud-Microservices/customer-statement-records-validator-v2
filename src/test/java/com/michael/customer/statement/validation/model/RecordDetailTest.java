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
public class RecordDetailTest {

	@Test
	public void testRecordDetails(){
		RecordDetail recordDetail1 = new RecordDetail();
		recordDetail1.setReference(Long.parseLong("177666"));
		recordDetail1.setAccountNumber("NL93ABNA0585619023");
		recordDetail1.setDescription("Flowers for Rik Theuß");
		recordDetail1.setStartBalance(Double.parseDouble("44.85"));
		recordDetail1.setMutation(Double.parseDouble("-22.24"));
		recordDetail1.setEndBalance(Double.parseDouble("22.61"));
		recordDetail1.setValid(true);

		Assert.assertNotEquals(null, recordDetail1);
		Assert.assertNotEquals(null, recordDetail1.toString());
		assertEquals(Long.parseLong("177666"), recordDetail1.getReference());
		assertEquals("NL93ABNA0585619023", recordDetail1.getAccountNumber());
		assertEquals("Flowers for Rik Theuß", recordDetail1.getDescription());
		assertEquals(Double.parseDouble("44.85"), recordDetail1.getStartBalance(),0); // Third parameter stands for delta. '0' means it should have to have the exact match 
		assertEquals(Double.parseDouble("-22.24"), recordDetail1.getMutation(),0);
		assertEquals(Double.parseDouble("22.61"), recordDetail1.getEndBalance(),0);
		Assert.assertTrue(recordDetail1.isValid());

	}
}
