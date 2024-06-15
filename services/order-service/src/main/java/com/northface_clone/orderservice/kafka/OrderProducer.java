package com.northface_clone.orderservice.kafka;

import com.northface_clone.orderservice.dto.request.OrderConfirmationRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderProducer {

    private final KafkaTemplate<String, OrderConfirmationRequestDTO> kafkaTemplate;

    public void sendOrderConfirmation(OrderConfirmationRequestDTO orderConfirmation ){
        log.info("Sending Order confirmation");
        Message<OrderConfirmationRequestDTO> message = MessageBuilder
                .withPayload(orderConfirmation)
                .setHeader(KafkaHeaders.TOPIC,"order-topic")
                .build();
        kafkaTemplate.send(message);
    }
}
