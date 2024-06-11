package com.northface_clone.orderservice.service.impl;

import com.northface_clone.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl {

    private final OrderRepository repository;
}
