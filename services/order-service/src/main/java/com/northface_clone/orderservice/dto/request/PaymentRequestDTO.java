package com.northface_clone.orderservice.dto.request;

import com.northface_clone.orderservice.dto.response.CustomerResponseDTO;
import com.northface_clone.orderservice.models.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequestDTO(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Long orderId,
        String orderReference,
        CustomerResponseDTO customer
) {
}
