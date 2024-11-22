package com.tesco.enquiry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@EnableWebMvc
@SpringBootApplication
public class CreditLimitEnquiryServiceApplication {
//execution starts here
	public static void main(String[] args) {
		SpringApplication.run(CreditLimitEnquiryServiceApplication.class, args);
	}

}
