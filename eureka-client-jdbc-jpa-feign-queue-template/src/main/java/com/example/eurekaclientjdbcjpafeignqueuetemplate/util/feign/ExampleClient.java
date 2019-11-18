package com.example.eurekaclientjdbcjpafeignqueuetemplate.util.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "<service-name>")
public interface ExampleClient {
}
