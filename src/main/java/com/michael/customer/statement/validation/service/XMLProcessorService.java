/**
 * 
 */
package com.michael.customer.statement.validation.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.michael.customer.statement.validation.exception.InvalidDataException;
import com.michael.customer.statement.validation.model.RecordDetail;
import com.michael.customer.statement.validation.model.Records;

/**
 * @author Michael Philomin Raj
 *
 */
@Service
public class XMLProcessorService {

	private static final Logger LOGGER = LoggerFactory.getLogger(XMLProcessorService.class);


	public List<RecordDetail> convertXmlToReportDetails(MultipartFile file){

		LOGGER.info("XMLProcessorService -> convertXmlToReportDetails");

		List<RecordDetail> recordDetails = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Records.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Records records = (Records) unmarshaller.unmarshal(file.getInputStream());
			recordDetails = Arrays.asList(records.getRecord()).stream().map(record -> {
				RecordDetail recordDetail = new RecordDetail();
				recordDetail.setReference(Long.parseLong((record.getReference()==null?"0":record.getReference())));
				recordDetail.setAccountNumber(record.getAccountNumber());
				recordDetail.setDescription(record.getDescription());
				recordDetail.setStartBalance(Double.parseDouble(record.getStartBalance()));
				recordDetail.setMutation(Double.parseDouble(record.getMutation()));
				recordDetail.setEndBalance(Double.parseDouble(record.getEndBalance()));
				return recordDetail;
			}).collect(Collectors.toList());

		}catch (Exception e) {
			LOGGER.info("XMLProcessorService -> Exception at convertXmlToReportDetails : ", e);
			throw new InvalidDataException("Exception at convertXmlToReportDetails - File name : " + file.getOriginalFilename());
		}
		return recordDetails;
	}


}
