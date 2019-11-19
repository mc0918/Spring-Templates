package com.example.oath2jdbcservertemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class Oath2JdbcServerTemplateApplication {

	/*
	TO RUN THIS APP:
		1. Enter your own info for application.properties
		2. configure authorities in OAuthConfig.java
		3. configure prepared statements in SecurityConfig.java
		4. define endpoint in UserInfoController.java
	 */
	public static void main(String[] args) {
		SpringApplication.run(Oath2JdbcServerTemplateApplication.class, args);
	}

}
