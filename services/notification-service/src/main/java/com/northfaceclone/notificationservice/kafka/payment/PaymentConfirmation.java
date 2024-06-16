package com.northfaceclone.notificationservice.kafka.payment;

import com.northfaceclone.notificationservice.dto.model.PaymentMethod;

import java.math.BigDecimal;

public record PaymentConfirmation(
        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerFirstName,
        String customerLastName,
        String customerEmail
) {
}