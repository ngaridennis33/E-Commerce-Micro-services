package com.northface_clone.orderservice.controller;


import com.northface_clone.orderservice.dto.request.OrderRequestDTO;
import com.northface_clone.orderservice.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
