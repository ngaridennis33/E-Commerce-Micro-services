package com.northface_clone.orderservice.service.impl;

import com.northface_clone.orderservice.dto.request.OrderLineRequestDTO;
import com.northface_clone.orderservice.dto.response.OrderLineResponseDTO;
import com.northface_clone.orderservice.mapper.OrderLineMapper;
import com.northface_clone.orderservice.repository.OrderLineRepository;
import com.northface_clone.orderservice.service.OrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderLineServiceImpl implements OrderLineService {

    private final OrderLineRepository repository;
    private final OrderLineMapper mapper;


    //  Save Order Into OrderLine
    public Long saveOrderLine(OrderLineRequestDTO request){
        var order = mapper.toOrderLine(request);
        return repository.save(order).getId();
    }

    //  Get Order from OrderLine
    public List<OrderLineResponseDTO> findAllByOrderId(Long orderId){
        return repository.findAllByOrderId(orderId)
                .stream()
                .map(mapper::toOrderLineResponse)
                .collect(Collectors.toList());
    };
}
