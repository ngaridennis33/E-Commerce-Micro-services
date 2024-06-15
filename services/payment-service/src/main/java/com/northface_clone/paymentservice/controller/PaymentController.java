package com.northface_clone.paymentservice.controller;


import com.northface_clone.paymentservice.dto.request.PaymentRequestDTO;
import com.northface_clone.paymentservice.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService service;

    @PostMapping
    public ResponseEntity<Long> createPayment(
            @RequestBody @Valid PaymentRequestDTO request
    ){
        return ResponseEntity.ok(service.createPayment(request));

    }



}
