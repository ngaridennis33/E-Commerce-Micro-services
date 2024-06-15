package com.northface_clone.orderservice.service;

import com.northface_clone.orderservice.dto.request.OrderLineRequestDTO;

public interface OrderLineService {

    //  Save Order and return OrderLineId
    Long saveOrderLine(OrderLineRequestDTO request);
}
