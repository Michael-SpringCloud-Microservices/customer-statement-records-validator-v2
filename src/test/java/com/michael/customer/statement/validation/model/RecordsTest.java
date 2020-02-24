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
public class RecordsTest {
	
	@Test
	public void testRecords(){
		
		Record record1 = new Record();
		record1.setReference("177666");
		record1.setAccountNumber("NL93ABNA0585619023");
		record1.setDescription("Flowers for Rik Theuß");
		record1.setStartBalance("44.85");
		record1.setMutation("-22.24");
		record1.setEndBalance("22.61");
		
		Record record2 = new Record();
		record2.setReference("112806");
		record2.setAccountNumber("NL69ABNA0433647324");
		record2.setDescription("Subscription for Jan Theußß");
		record2.setStartBalance("45.59");
		record2.setMutation("48.18");
		record2.setEndBalance("93.77");

		Record[] recordArray = {record1,record2};
		
		Records records = new Records();
		records.setRecord(recordArray);
		
		Assert.assertNotEquals(null, records.getRecord());
		Assert.assertNotEquals(null, records.getRecord().toString());
		assertEquals(2, records.getRecord().length);

	}

}
