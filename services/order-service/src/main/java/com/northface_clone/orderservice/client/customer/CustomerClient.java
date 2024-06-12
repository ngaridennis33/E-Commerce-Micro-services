package com.northface_clone.orderservice.client.customer;


import com.northface_clone.orderservice.dto.response.CustomerResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "customer-service",
        url = "${application.config.customer-url}"
)
public interface CustomerClient {

    @GetMapping("/{user-id")
    Optional<CustomerResponseDTO> findCustomerById(@PathVariable("customer-id") Long customerId);
}
