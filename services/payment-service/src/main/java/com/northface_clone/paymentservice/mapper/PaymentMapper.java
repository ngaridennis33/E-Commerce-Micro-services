package com.northface_clone.paymentservice.mapper;

import com.northface_clone.paymentservice.dto.request.PaymentRequestDTO;
import com.northface_clone.paymentservice.models.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {
    public Payment toPayment(PaymentRequestDTO request) {
        return Payment.builder()
                .id(request.id())
                .orderId(request.orderId())
                .paymentMethod(request.paymentMethod())
                .amount(request.amount())
                .build();
    }
}
