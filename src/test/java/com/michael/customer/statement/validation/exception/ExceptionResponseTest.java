/**
 * 
 */
package com.michael.customer.statement.validation.exception;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Michael Philomin Raj
 *
 */
@RunWith(SpringRunner.class)
public class ExceptionResponseTest {

	
	@Test
	public void testExceptionResponse(){
		Date sysDate = new Date();
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),"some message","some details");
			
		Assert.assertNotEquals(null, exceptionResponse);
		Assert.assertNotEquals(null, exceptionResponse.toString());
		assertEquals(sysDate, exceptionResponse.getTimestamp());
		assertEquals("some message", exceptionResponse.getMessage());
		assertEquals("some details", exceptionResponse.getDetails());

	}
}
