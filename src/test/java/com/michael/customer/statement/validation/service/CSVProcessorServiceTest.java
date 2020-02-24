/**
 * 
 */
package com.michael.customer.statement.validation.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;

import com.michael.customer.statement.validation.model.RecordDetail;

/**
 * @author Michael Philomin Raj
 *
 */
@RunWith(SpringRunner.class)
public class CSVProcessorServiceTest {
	
	@InjectMocks
	CSVProcessorService csvProcessorService;
	
	@Test
	public void testConvertCsvToReportDetails()throws IOException{
		File csvFile = new File(this.getClass().getResource("/records.csv").getFile());
		InputStream is = new FileInputStream(csvFile);
		MockMultipartFile multipartFile = new MockMultipartFile("csv", "records.csv", "text/csv", is);
		is.close();
		List<RecordDetail> result = csvProcessorService.convertCsvToReportDetails(multipartFile);
		Assert.assertNotEquals(null, result);
		assertEquals(10, result.size());
	}

}
