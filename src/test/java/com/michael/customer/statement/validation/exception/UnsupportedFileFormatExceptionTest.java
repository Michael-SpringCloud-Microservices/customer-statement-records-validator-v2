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
public class UnsupportedFileFormatExceptionTest {

	@Test
	public void TestUnsupportedFileFormatException(){
		UnsupportedFileFormatException unsupportedFileFormatException = new UnsupportedFileFormatException("Given file format is not supported");
		Assert.assertNotEquals(null, unsupportedFileFormatException);
		assertEquals("Given file format is not supported", unsupportedFileFormatException.getMessage());
	}
}
