package com.northface_clone.orderservice.dto.request;

import com.northface_clone.orderservice.dto.response.CustomerResponseDTO;
import com.northface_clone.orderservice.dto.response.PurchaseResponseDTO;
import com.northface_clone.orderservice.models.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmationRequestDTO(
        String OrderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponseDTO customer,
        List<PurchaseResponseDTO> products
) {
}
