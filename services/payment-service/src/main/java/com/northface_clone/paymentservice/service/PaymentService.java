package com.northface_clone.paymentservice.service;

import com.northface_clone.paymentservice.dto.request.PaymentRequestDTO;

public interface PaymentService {

    //  Create a Payment
    Long createPayment(PaymentRequestDTO request);

}
