package com.northfaceclone.userservice.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "user-service", url = "${application.config.user-url}")
public interface UserClient {

}