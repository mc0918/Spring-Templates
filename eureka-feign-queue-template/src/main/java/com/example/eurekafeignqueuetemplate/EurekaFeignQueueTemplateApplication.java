package com.example.eurekafeignqueuetemplate;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class EurekaFeignQueueTemplateApplication {

	/*
	TO RUN THIS APP:
		1. change <name> to name of service
		2. config the service you're feigning or delete ModelClient
	 */

	public static final String TOPIC_EXCHANGE_NAME = "<name>-exchange";
	public static final String QUEUE_NAME = "<name>-queue";
	public static final String ROUTING_KEY = "<name>.add.#";

	@Bean
	Queue queue() {
		return new Queue(QUEUE_NAME, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(TOPIC_EXCHANGE_NAME);
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
	}

	@Bean
	public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}


	public static void main(String[] args) {
		SpringApplication.run(EurekaFeignQueueTemplateApplication.class, args);
	}

}
