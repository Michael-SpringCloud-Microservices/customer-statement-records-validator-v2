/**
 * 
 */
package com.michael.customer.statement.validation.exception;

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
public class InvalidDataExceptionTest {

	@Test
	public void TestInvalidDataException(){
		InvalidDataException invalidDataException = new InvalidDataException("Some data is invalid");
		Assert.assertNotEquals(null, invalidDataException);
		assertEquals("Some data is invalid", invalidDataException.getMessage());
	}
}
