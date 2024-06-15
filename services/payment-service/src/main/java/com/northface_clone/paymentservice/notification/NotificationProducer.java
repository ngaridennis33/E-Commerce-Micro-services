package com.northface_clone.paymentservice.notification;

import com.northface_clone.paymentservice.dto.request.PaymentNotificationRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationProducer {

    private final KafkaTemplate<String, PaymentNotificationRequestDTO>  kafkaTemplate;

    public void sendNotification(PaymentNotificationRequestDTO request){
        log.info("Sending notification with <{}>", request);
        Message<PaymentNotificationRequestDTO> message = MessageBuilder
                .withPayload(request)
                .setHeader(TOPIC, "payment-topic")
                .build();
        kafkaTemplate.send(message);
    }
}
