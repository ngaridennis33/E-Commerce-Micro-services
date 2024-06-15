package com.northface_clone.paymentservice.service.impl;

import com.northface_clone.paymentservice.dto.request.PaymentNotificationRequestDTO;
import com.northface_clone.paymentservice.dto.request.PaymentRequestDTO;
import com.northface_clone.paymentservice.mapper.PaymentMapper;
import com.northface_clone.paymentservice.notification.NotificationProducer;
import com.northface_clone.paymentservice.repository.PaymentRepository;
import com.northface_clone.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repository;
    private final PaymentMapper mapper;
    private final NotificationProducer notificationProducer;

    public Long createPayment(PaymentRequestDTO request){
        var payment = repository.save(mapper.toPayment(request));

        notificationProducer.sendNotification(
                new PaymentNotificationRequestDTO(
                        request.orderReference(),
                        request.amount(),
                        request.paymentMethod(),
                        request.customer().firstname(),
                        request.customer().lastname(),
                        request.customer().email()
                )
        );
        return payment.getId();
    }
}
