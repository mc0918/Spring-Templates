package com.example.eurekaclientjdbcjpafeignqueuetemplate;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class EurekaClientJdbcJpaFeignQueueTemplateApplication {

	/*
	SET UP TO USE JPA, TO USE JDBC CHANGE ANNOTATIONS

	TO RUN APP:
		1. enter real database name in BOTH application.properties files
		2. enter config information in bootstrap.properties
		3. enter real feign client name and configure
		4. change controller, models, etc to suit your needs
	 */

	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
		return rabbitTemplate;
	}

	@Bean
	public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientJdbcJpaFeignQueueTemplateApplication.class, args);
	}

}
