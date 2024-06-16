package com.northfaceclone.notificationservice.kafka.order;

import com.northfaceclone.notificationservice.dto.model.Customer;
import com.northfaceclone.notificationservice.dto.model.PaymentMethod;
import com.northfaceclone.notificationservice.dto.model.Product;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        Customer customer,
        List<Product> products
) {
}
