package com.michael.customer.statement.validation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @author Michael Philomin Raj
 *
 */

@SpringBootApplication
public class CustomerStatementRecordsValidatorV2Application {

	public static void main(String[] args) {
		SpringApplication.run(CustomerStatementRecordsValidatorV2Application.class, args);
	}

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(-1);
		return multipartResolver;
	}

}
