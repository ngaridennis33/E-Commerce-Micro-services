package com.northface_clone.orderservice.service.impl;

import com.northface_clone.orderservice.client.customer.CustomerClient;
import com.northface_clone.orderservice.client.product.ProductClient;
import com.northface_clone.orderservice.dto.request.*;
import com.northface_clone.orderservice.dto.response.OrderResponseDTO;
import com.northface_clone.orderservice.exception.BusinessException;
import com.northface_clone.orderservice.kafka.OrderProducer;
import com.northface_clone.orderservice.mapper.OrderMapper;
import com.northface_clone.orderservice.payment.PaymentClient;
import com.northface_clone.orderservice.repository.OrderRepository;
import com.northface_clone.orderservice.service.OrderLineService;
import com.northface_clone.orderservice.service.OrderService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;

    public Long createOrder(OrderRequestDTO request) {

        // Check the customer --> openFeign
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No customer exist with the provided " +
                        "ID:"));

        //  purchase the product --> Product-ms(RestTemplate)
        var purchasedProducts = this.productClient.purchaseProducts(request.products());

        //  Persist the Order object
        var order = this.repository.save(mapper.toOrder(request));

        //  Persist order Lines
        for (PurchaseRequestDTO purchaseRequest : request.products()) {
            orderLineService.saveOrderLine(
                    new OrderLineRequestDTO(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }

        // Start Payment process
        var paymentRequest = new PaymentRequestDTO(
                request.amount(),
                request.paymentMethod(),
                order.getId(),
                order.getReference(),
                customer
        );
        paymentClient.requestOrderPayment(paymentRequest);

        //  Send the order confirmation --> notification-ms(kafka)
        orderProducer.sendOrderConfirmation(
                new OrderConfirmationRequestDTO(
                        request.reference(),
                        request.amount(),
                        request.paymentMethod(),
                        customer,
                        purchasedProducts
                )
        );

        return order.getId();
    }

    //  Get All Orders
    public List<OrderResponseDTO> findAllOrders() {

        return repository.findAll()
                .stream()
                .map(mapper::fromOrder)
                .collect(Collectors.toList());
    }

    //  Get Specific Order By ID
    public OrderResponseDTO findOrderById(Long orderId) {
        return repository.findById(orderId)
                .map(mapper::fromOrder)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No order found with the provided ID: " +
                        "%d", orderId)));
    }
}
