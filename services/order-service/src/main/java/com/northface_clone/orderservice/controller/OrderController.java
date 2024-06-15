package com.northface_clone.orderservice.controller;


import com.northface_clone.orderservice.dto.request.OrderRequestDTO;
import com.northface_clone.orderservice.dto.response.OrderResponseDTO;
import com.northface_clone.orderservice.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    //  Create a new order
    @PostMapping
    public ResponseEntity<Long> createOrder(
            @RequestBody @Valid OrderRequestDTO request
    ){
        return ResponseEntity.ok(service.createOrder(request));
    }

    //  Get All Orders
    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> findAllOrders(){

        return ResponseEntity.ok(service.findAllOrders());
    }

    //  Get Specific Order By id
    @GetMapping("/{order-id}")
    public ResponseEntity<OrderResponseDTO> getOrderById(
            @PathVariable("order-id") Long orderId
    ){
        return ResponseEntity.ok(service.findOrderById(orderId));
    }
}
