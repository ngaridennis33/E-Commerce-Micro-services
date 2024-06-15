package com.northface_clone.orderservice.payment;


import com.northface_clone.orderservice.dto.request.PaymentRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "product-service",
        url = "${application.config.payment-url}"
)
public interface PaymentClient {

    @PostMapping
    Long requestOrderPayment(@RequestBody PaymentRequestDTO request);
}
