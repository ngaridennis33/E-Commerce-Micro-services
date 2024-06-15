package com.northface_clone.paymentservice.dto.request;

import com.northface_clone.paymentservice.models.PaymentMethod;

import java.math.BigDecimal;

public record PaymentNotificationRequestDTO(
        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerFirstName,
        String customerLastName,
        String customerEmail
) {
}
