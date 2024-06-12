package com.northface_clone.orderservice.service.impl;

import com.northface_clone.orderservice.dto.request.OrderLineRequestDTO;
import com.northface_clone.orderservice.mapper.OrderLineMapper;
import com.northface_clone.orderservice.repository.OrderLineRepository;
import com.northface_clone.orderservice.service.OrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderLineServiceImpl implements OrderLineService {

    private final OrderLineRepository repository;
    private final OrderLineMapper mapper;


    public void saveOrderLine(OrderLineRequestDTO request){

    }
}
