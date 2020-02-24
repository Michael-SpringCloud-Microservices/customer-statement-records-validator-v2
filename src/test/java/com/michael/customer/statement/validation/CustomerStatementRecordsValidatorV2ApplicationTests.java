package com.michael.customer.statement.validation;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author Michael Philomin Raj
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class CustomerStatementRecordsValidatorV2ApplicationTests {

	@LocalServerPort
	int randomServerPort;
	
	@Test
	public void contextLoads() {
	}

	@SuppressWarnings({ "rawtypes", "unchecked"})
	@Test
	public void testUploaedCsvRecords() throws URISyntaxException,IOException
	{
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + randomServerPort + "/statement/upload";
		//final String baseUrl = "http://localhost:8110/statement/upload";

		URI uri = new URI(baseUrl);

		File csvFile = new File(this.getClass().getResource("/records.csv").getFile());
		MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>();
		bodyMap.add("file", new FileSystemResource(csvFile));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);

		ResponseEntity<List> result = restTemplate.postForEntity(uri, requestEntity, List.class);

		Assert.assertEquals(200, result.getStatusCodeValue());
		assertNotNull(result.getBody());
		Assert.assertEquals(2, result.getBody().size());
		assertNotNull(result.getBody().get(0));

		Map<String,String> reportDetails1 = (Map<String, String>) result.getBody().get(0);
		assertNotNull(reportDetails1);
		Assert.assertEquals("112806", reportDetails1.get("transactionReference"));
		Assert.assertEquals("Clothes from Peter de Vries", reportDetails1.get("description"));

		assertNotNull(result.getBody().get(1));
		Map<String,String> reportDetails2 = (Map<String, String>) result.getBody().get(1);
		assertNotNull(reportDetails2);
		Assert.assertEquals("112806", reportDetails2.get("transactionReference"));
		Assert.assertEquals("Tickets for Erik Dekker", reportDetails2.get("description"));

	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testUploaedXmlRecords() throws URISyntaxException,IOException
	{
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + randomServerPort + "/statement/upload";
		//final String baseUrl = "http://localhost:8110/statement/upload";

		URI uri = new URI(baseUrl);

		File csvFile = new File(this.getClass().getResource("/records.xml").getFile());
		MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>();
		bodyMap.add("file", new FileSystemResource(csvFile));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);

		ResponseEntity<List> result = restTemplate.postForEntity(uri, requestEntity, List.class);

		Assert.assertEquals(200, result.getStatusCodeValue());
		assertNotNull(result.getBody());
		Assert.assertEquals(2, result.getBody().size());
		assertNotNull(result.getBody().get(0));

		Map<String,String> reportDetails1 = (Map<String, String>) result.getBody().get(0);
		assertNotNull(reportDetails1);
		Assert.assertEquals("154270", reportDetails1.get("transactionReference"));
		Assert.assertEquals("Candy for Peter de Vries", reportDetails1.get("description"));

		assertNotNull(result.getBody().get(1));
		Map<String,String> reportDetails2 = (Map<String, String>) result.getBody().get(1);
		assertNotNull(reportDetails2);
		Assert.assertEquals("140269", reportDetails2.get("transactionReference"));
		Assert.assertEquals("Tickets for Vincent Dekker", reportDetails2.get("description"));
	}
}
