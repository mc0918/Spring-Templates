package com.example.eurekaservertemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaServerTemplateApplication {

	/*
	THIS APP IS GOOD TO GO, JUST RUN IT (or change default port to what you want)
	 */

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerTemplateApplication.class, args);
	}

}
