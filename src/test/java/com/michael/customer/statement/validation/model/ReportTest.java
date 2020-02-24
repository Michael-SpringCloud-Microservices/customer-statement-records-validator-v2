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
public class ReportTest {
	
	@Test
	public void testReport(){
		
		Report report1 = new Report();
		report1.setTransactionReference("112806");
		report1.setDescription("Clothes from Peter de Vries");
		
		Assert.assertNotEquals(null, report1);
		Assert.assertNotEquals(null, report1.toString());
		assertEquals("112806", report1.getTransactionReference());
		assertEquals("Clothes from Peter de Vries", report1.getDescription());
	}

}
