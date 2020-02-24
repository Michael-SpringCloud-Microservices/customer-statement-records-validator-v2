/**
 * 
 */
package com.michael.customer.statement.validation.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import com.michael.customer.statement.validation.data.UserStatementDataProvider;
import com.michael.customer.statement.validation.model.RecordDetail;
import com.michael.customer.statement.validation.model.Report;


/**
 * @author Michael Philomin Raj
 *
 */
@RunWith(SpringRunner.class)
public class StatementRecordsValidationServiceTest {

	@InjectMocks
	StatementRecordsValidationService statementRecordsValidationService;	

	@Test
	public void CsvWithGivenData() throws Exception {

		// Stubbing of recordDetails
		List<RecordDetail> recordDetails = UserStatementDataProvider.getCsvData();

		List<Report> result = statementRecordsValidationService.validateStatementRecords(recordDetails);
		Assert.assertNotEquals(null, result);
		assertEquals(2, result.size());
		assertEquals("112806", result.get(0).getTransactionReference());
		assertEquals("Clothes from Peter de Vries", result.get(0).getDescription());
		assertEquals("112806", result.get(1).getTransactionReference());
		assertEquals("Tickets for Erik Dekker", result.get(1).getDescription());
	}

	@Ignore
	@Test
	public void XmlWithGivenData() throws Exception {

		// Stubbing of recordDetails
		List<RecordDetail> recordDetails = UserStatementDataProvider.getXmLData();

		List<Report> result = statementRecordsValidationService.validateStatementRecords(recordDetails);
		Assert.assertNotEquals(null, result);
		assertEquals(2, result.size());
		assertEquals("154270", result.get(0).getTransactionReference());
		assertEquals("Candy for Peter de Vries", result.get(0).getDescription());
		assertEquals("140269", result.get(1).getTransactionReference());
		assertEquals("Tickets for Vincent Dekker", result.get(1).getDescription());		
	}
	

}
