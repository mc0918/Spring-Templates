package com.example.securityjdbcjpatemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = SecurityAutoConfiguration.class) //disables automatic login screen, etc
@SpringBootApplication
public class SecurityJdbcJpaTemplateApplication {

	/*
	All that needs to be done to run this is:
	 	1. set up connection to database
	 	2. write controller endpoints
	 	3. configure security authorizations for those endpoints
	 */

	public static void main(String[] args) {
		SpringApplication.run(SecurityJdbcJpaTemplateApplication.class, args);
	}

}
