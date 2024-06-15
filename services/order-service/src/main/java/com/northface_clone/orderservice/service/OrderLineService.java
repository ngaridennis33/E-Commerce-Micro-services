package com.northface_clone.orderservice.service;

import com.northface_clone.orderservice.dto.request.OrderLineRequestDTO;
import com.northface_clone.orderservice.dto.response.OrderLineResponseDTO;

import java.util.List;

public interface OrderLineService {

    //  Save Order and return OrderLineId
    Long saveOrderLine(OrderLineRequestDTO request);

    //  Find all OrderLine
    List<OrderLineResponseDTO> findAllByOrderId(Long orderId);
}
