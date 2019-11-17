package com.example.configservertemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerTemplateApplication {

	/*
	ALL THAT'S NEEDED TO FINISH SETTING UP THE SERVER IS TO COMPLETE THE APPLICATION.PROPERTIES FILE
	 */

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerTemplateApplication.class, args);
	}

}
