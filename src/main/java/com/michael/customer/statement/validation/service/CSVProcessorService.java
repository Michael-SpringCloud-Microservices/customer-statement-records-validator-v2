/**
 * 
 */
package com.michael.customer.statement.validation.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.michael.customer.statement.validation.model.RecordDetail;

/**
 * @author Michael Philomin Raj
 *
 */
@Service
public class CSVProcessorService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CSVProcessorService.class);

	public List<RecordDetail> convertCsvToReportDetails(MultipartFile file) throws IOException{

		LOGGER.info("CSVProcessorService -> convertCsvToReportDetails");

		List<RecordDetail> recordDetails = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			String line;
			boolean firstLine = true;
			while((line = reader.readLine()) != null) {
				if(firstLine) {
					firstLine = false;
					continue;
				}
				String[] columnValues = line.split(",");
				RecordDetail recordDetail = new RecordDetail();
				recordDetail.setReference(Long.parseLong(replaceNullByBlank(columnValues[0])));
				recordDetail.setAccountNumber(replaceNullByBlank(columnValues[1]));
				recordDetail.setDescription(replaceNullByBlank(columnValues[2]));
				recordDetail.setStartBalance(Double.parseDouble(replaceNullByBlank(columnValues[3])));
				recordDetail.setMutation(Double.parseDouble(replaceNullByBlank(columnValues[4])));
				recordDetail.setEndBalance(Double.parseDouble(replaceNullByBlank(columnValues[5])));
				recordDetails.add(recordDetail);
			}
		}
		return recordDetails;
	}
	private String replaceNullByBlank(String param){
		return param==null?"":param;
	}
}
