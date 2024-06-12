package com.northface_clone.orderservice.service.impl;

import com.northface_clone.orderservice.client.customer.CustomerClient;
import com.northface_clone.orderservice.client.product.ProductClient;
import com.northface_clone.orderservice.dto.request.OrderLineRequestDTO;
import com.northface_clone.orderservice.dto.request.OrderRequestDTO;
import com.northface_clone.orderservice.dto.request.PurchaseRequestDTO;
import com.northface_clone.orderservice.exception.BusinessException;
import com.northface_clone.orderservice.mapper.OrderMapper;
import com.northface_clone.orderservice.repository.OrderRepository;
import com.northface_clone.orderservice.service.OrderLineService;
import com.northface_clone.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;

    public Long createOrder(OrderRequestDTO request){

        // Check the customer --> openFeign
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(()-> new BusinessException("Cannot create order:: No customer exist with the provided ID:"));

        //  purchase the product --> Product-ms(RestTemplate)
        this.productClient.purchaseProducts(request.products());

        //  Persist the Order object
        var order = this.repository.save(mapper.toOrder(request));

        //  Persist order lines
        for (PurchaseRequestDTO purchaseRequest : request.products()){
            orderLineService.saveOrderLine(
                    new OrderLineRequestDTO(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }

        //  Start payment process

        //  Send the order confirmation --> notification-ms(kafka)

        return null;
    }
}
