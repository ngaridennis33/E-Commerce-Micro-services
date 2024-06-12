package com.northface_clone.orderservice.service;

import com.northface_clone.orderservice.dto.request.OrderRequestDTO;

public interface OrderService {

    //  Create a new Order
    Long createOrder(OrderRequestDTO request);

}
