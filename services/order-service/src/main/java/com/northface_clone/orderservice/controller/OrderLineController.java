package com.northface_clone.orderservice.controller;


import com.northface_clone.orderservice.dto.response.OrderLineResponseDTO;
import com.northface_clone.orderservice.service.OrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order-line")
@RequiredArgsConstructor
public class OrderLineController {

    private final OrderLineService service;

    //  Get All OrderLines
    @GetMapping("/order/{order-id}")
    public ResponseEntity<List<OrderLineResponseDTO>> findAllOrderById(
            @PathVariable("order-id") Long orderId
    ){
        return ResponseEntity.ok(service.findAllByOrderId(orderId));
    }
}
