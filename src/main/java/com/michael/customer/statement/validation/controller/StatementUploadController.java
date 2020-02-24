package com.michael.customer.statement.validation.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.michael.customer.statement.validation.model.Report;
import com.michael.customer.statement.validation.service.FileValidationService;

/**
 * @author Michael Philomin Raj
 *
 */

@RestController
@RequestMapping("/statement")
public class StatementUploadController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StatementUploadController.class);

	@Autowired
	private FileValidationService fileValidationService;

	@PostMapping(value = "/upload")    
	@ApiOperation(value = "Make a POST request to upload the file",produces = "application/json", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public List<Report> validateFileUpload(
			@ApiParam(name = "file", value = "Select the file to Upload", required = true)
			@RequestParam("file") MultipartFile file) throws IOException  {
		LOGGER.info("StatementUploadController -> validateFileUpload");   
		return fileValidationService.validateFile(file);
	}


}
