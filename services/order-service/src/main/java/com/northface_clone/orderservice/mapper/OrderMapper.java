package com.northface_clone.orderservice.mapper;

import com.northface_clone.orderservice.dto.request.OrderRequestDTO;
import com.northface_clone.orderservice.dto.response.OrderResponseDTO;
import com.northface_clone.orderservice.models.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {

    public Order toOrder(OrderRequestDTO request) {

        return Order.builder()
                .id(request.id())
                .reference(request.reference())
                .customerId(request.customerId())
                .totalAmount(request.amount())
                .paymentMethod(request.paymentMethod())
                .build();
    }

    public OrderResponseDTO fromOrder(Order order) {

        return new OrderResponseDTO(
                order.getId(),
                order.getReference(),
                order.getTotalAmount(),
                order.getPaymentMethod(),
                order.getCustomerId()
        );
    }
}
