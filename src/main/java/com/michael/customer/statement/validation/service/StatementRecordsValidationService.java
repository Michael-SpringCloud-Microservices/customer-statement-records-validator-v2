package com.michael.customer.statement.validation.service;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.michael.customer.statement.validation.model.RecordDetail;
import com.michael.customer.statement.validation.model.Report;

/**
 * @author Michael Philomin Raj
 *
 */
@Service
public class StatementRecordsValidationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(StatementRecordsValidationService.class);

	//	0	A digit - always displayed, even if number has less digits (then 0 is displayed)
	//  #	A digit, leading zeroes are omitted.
	private static final NumberFormat formatter = new DecimalFormat("#0.00"); 

	public List<Report> validateStatementRecords(List<RecordDetail> recordDetails) throws IOException {

		LOGGER.info("StatementRecordsValidationService -> validateRecords");

		List<Report> reports = new ArrayList<>();

		//Identifying failed records ( ie. records having the duplication of Transaction reference or the improper End Balance)
		List<Long> processedRecords = new ArrayList<>();

		recordDetails.forEach(recordDetail ->{
			if (isNotValid(processedRecords,recordDetail)){
				reports.add(recordDetail.convertToReport());
			}				
			processedRecords.add(recordDetail.getReference());
		});
		processedRecords.clear();
		return reports; 
	}

	private boolean isNotValid(List<Long> processedRecords,RecordDetail recordDetail){
		return isDuplicated(processedRecords,recordDetail) || hasInvalidEndBalance(recordDetail);
	}

	private boolean isDuplicated(List<Long> processedRecords,RecordDetail recordDetail){
		return !processedRecords.isEmpty() && processedRecords.contains(recordDetail.getReference());
	}

	private boolean hasInvalidEndBalance(RecordDetail recordDetail){
		return Double.parseDouble(formatter.format((recordDetail.getStartBalance() + recordDetail.getMutation()))) != Double.parseDouble(formatter.format(recordDetail.getEndBalance()));
	}
}
