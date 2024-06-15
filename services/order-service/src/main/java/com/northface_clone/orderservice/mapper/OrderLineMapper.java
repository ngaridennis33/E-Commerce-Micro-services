package com.northface_clone.orderservice.mapper;

import com.northface_clone.orderservice.dto.request.OrderLineRequestDTO;
import com.northface_clone.orderservice.models.Order;
import com.northface_clone.orderservice.models.OrderLine;
import org.springframework.stereotype.Service;

@Service
public class OrderLineMapper {
    public OrderLine toOrderLine(OrderLineRequestDTO request) {
        return OrderLine.builder()
                .id(request.id())
                .quantity((request.quantity()))
                .order(Order.builder()
                        .id(request.orderId())
                        .build())
                .productId(request.productId())
                .build();
    }
}
