package com.northface_clone.paymentservice.dto.request;

import com.northface_clone.paymentservice.models.Customer;
import com.northface_clone.paymentservice.models.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequestDTO(
        Long id,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Long orderId,
        String orderReference,
        Customer customer
) {
}
