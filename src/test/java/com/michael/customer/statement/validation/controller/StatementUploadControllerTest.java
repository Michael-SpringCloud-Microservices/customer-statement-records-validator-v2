/**
 * 
 */
package com.michael.customer.statement.validation.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockMultipartFile;
//import org.springframework.test.context.junit4.SpringRunner;

import com.michael.customer.statement.validation.exception.UnsupportedFileFormatException;
import com.michael.customer.statement.validation.model.Report;
import com.michael.customer.statement.validation.service.FileValidationService;

/**
 * @author Michael Philomin Raj
 *
 */
@RunWith(MockitoJUnitRunner.class)
//@RunWith(SpringRunner.class)
public class StatementUploadControllerTest {

	@InjectMocks
	StatementUploadController statementUploadController;

	@Mock
	FileValidationService fileValidationService;



	@Test
	public void CsvFileWithGivenData() throws Exception {
		File csvFile = new File(this.getClass().getResource("/records.csv").getFile());
		InputStream is = new FileInputStream(csvFile);
		MockMultipartFile multipartFile = new MockMultipartFile("csv", "records.csv", "text/csv", is);
		is.close();
		List<Report> reports = new ArrayList<Report>();
		Report report1 = new Report();
		report1.setTransactionReference("112806");
		report1.setDescription("Clothes from Peter de Vries");
		reports.add(report1);
		Report report2 = new Report();
		report2.setTransactionReference("112806");
		report2.setDescription("Tickets for Erik Dekker");
		reports.add(report2);

		Mockito.when(fileValidationService.validateFile(multipartFile)).thenReturn(reports);

		List<Report> result = statementUploadController.validateFileUpload(multipartFile);
		Assert.assertNotEquals(null, result);
		assertEquals(2, result.size());
		assertEquals("112806", result.get(0).getTransactionReference());
		assertEquals("Clothes from Peter de Vries", result.get(0).getDescription());
		assertEquals("112806", result.get(1).getTransactionReference());
		assertEquals("Tickets for Erik Dekker", result.get(1).getDescription());    
		verify(fileValidationService, times(1)).validateFile(multipartFile);
	}

	@Test
	public void xmlFileWithGivenData() throws Exception {
		File xmlFile = new File(this.getClass().getResource("/records.xml").getFile());
		InputStream is = new FileInputStream(xmlFile);
		MockMultipartFile multipartFile = new MockMultipartFile("xml", "records.xml", "text/xml", is);
		is.close();
		List<Report> reports = new ArrayList<Report>();
		Report report1 = new Report();
		report1.setTransactionReference("154270");
		report1.setDescription("Candy for Peter de Vries");
		reports.add(report1);
		Report report2 = new Report();
		report2.setTransactionReference("140269");
		report2.setDescription("Tickets for Vincent Dekker");
		reports.add(report2);

		Mockito.when(fileValidationService.validateFile(multipartFile)).thenReturn(reports);
		List<Report> result = statementUploadController.validateFileUpload(multipartFile);
		Assert.assertNotEquals(null, result);
		assertEquals(2, result.size());
		assertEquals("154270", result.get(0).getTransactionReference());
		assertEquals("Candy for Peter de Vries", result.get(0).getDescription());
		assertEquals("140269", result.get(1).getTransactionReference());
		assertEquals("Tickets for Vincent Dekker", result.get(1).getDescription());	
		verify(fileValidationService, times(1)).validateFile(multipartFile);
	}

	@Test(expected = UnsupportedFileFormatException.class)
	public void unsupportedFileFormatWithTextFile() throws Exception {
		File textFile = new File(this.getClass().getResource("/records.txt").getFile());
		InputStream is = new FileInputStream(textFile);
		MockMultipartFile multipartFile = new MockMultipartFile("txt", "records.txt", "text/plain", is);
		is.close();
		Mockito.when(fileValidationService.validateFile(multipartFile)).thenThrow(new UnsupportedFileFormatException("The given file format txt is not supported"));
		statementUploadController.validateFileUpload(multipartFile);		
	}  



}
