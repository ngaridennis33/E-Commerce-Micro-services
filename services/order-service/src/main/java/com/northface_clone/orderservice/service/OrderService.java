package com.northface_clone.orderservice.service;

import com.northface_clone.orderservice.dto.request.OrderRequestDTO;
import com.northface_clone.orderservice.dto.response.OrderResponseDTO;

import java.util.List;

public interface OrderService {

    //  Create a new Order
    Long createOrder(OrderRequestDTO request);

    //  Get All Orders
    List<OrderResponseDTO> findAllOrders();

    //  Get Order By Id
    OrderResponseDTO findOrderById(Long orderId);
}
