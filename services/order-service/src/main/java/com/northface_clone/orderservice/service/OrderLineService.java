package com.northface_clone.orderservice.service;

import com.northface_clone.orderservice.dto.request.OrderLineRequestDTO;

public interface OrderLineService {

    //  Get the saved OrderLine
    void saveOrderLine(OrderLineRequestDTO request);
}
