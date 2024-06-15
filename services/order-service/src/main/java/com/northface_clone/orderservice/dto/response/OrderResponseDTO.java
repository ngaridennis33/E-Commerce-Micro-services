package com.northface_clone.orderservice.dto.response;

import com.northface_clone.orderservice.models.PaymentMethod;

import java.math.BigDecimal;

public record OrderResponseDTO(

        Long OrderId,
        String reference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Long customerId
) {
}
