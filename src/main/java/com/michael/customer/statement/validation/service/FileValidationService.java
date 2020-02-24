/**
 * 
 */
package com.michael.customer.statement.validation.service;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.michael.customer.statement.validation.exception.InvalidDataException;
import com.michael.customer.statement.validation.exception.UnsupportedFileFormatException;
import com.michael.customer.statement.validation.model.RecordDetail;
import com.michael.customer.statement.validation.model.Report;

/**
 * @author Michael Philomin Raj
 *
 */
@Service
public class FileValidationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileValidationService.class);

	private static final String xmlContentType1 = "text/xml"; // For Swagger UI 
	private static final String xmlContentType2 = "application/xml"; // For Integration Test
	private static final String csvContentType1 = "application/vnd.ms-excel";  // For Swagger UI
	private static final String csvContentType2 = "text/csv"; // For Integration Test

	private static final String XML = "xml";
	private static final String CSV = "csv";

	@Autowired
	CSVProcessorService csvProcessorService;

	@Autowired
	XMLProcessorService xmlProcessorService;

	@Autowired
	private StatementRecordsValidationService statementRecordsValidationService;

	public void validateFileSize(MultipartFile file) {
		if (file.isEmpty()){
			throw new InvalidDataException("File can't be empty");
		}
	}

	public List<Report> validateFile(MultipartFile file) throws IOException{
		String fileName = file.getOriginalFilename();
		String fileType = file.getContentType();

		LOGGER.info("FileValidationService -> fileName={}" ,fileName);
		LOGGER.info("FileValidationService -> fileType={}" ,fileType);

		validateFileSize(file);

		String fileExtension = getTheFileExtension(fileType);

		List<RecordDetail> recordDetails;
		
		switch (fileExtension) {
		case XML:
			recordDetails = xmlProcessorService.convertXmlToReportDetails(file);
			return statementRecordsValidationService.validateStatementRecords(recordDetails);
		case CSV:
			recordDetails = csvProcessorService.convertCsvToReportDetails(file);
			return statementRecordsValidationService.validateStatementRecords(recordDetails);
		default:
			throw new UnsupportedFileFormatException("The given file format "+ fileType + " is not supported");
		}
	}

	private String getTheFileExtension(String fileType){
		String fileExtension = fileType;
		if (fileType.equalsIgnoreCase(xmlContentType1) || fileType.equalsIgnoreCase(xmlContentType2)){
			fileExtension = XML;
		}else if (fileType.equalsIgnoreCase(csvContentType1) || fileType.equalsIgnoreCase(csvContentType2)){
			fileExtension = CSV;
		}
		return fileExtension;
	}

}
