package com.example.eurekafeignqueuetemplate.util.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "<service-name>")
public interface ModelClient {

}
