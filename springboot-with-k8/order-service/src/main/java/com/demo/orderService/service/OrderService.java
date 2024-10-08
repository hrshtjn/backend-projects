package com.demo.orderService.service;

import com.demo.orderService.client.InventoryClient;
import com.demo.orderService.dto.OrderRequest;
import com.demo.orderService.entity.Order;

import com.demo.orderService.event.OrderPlacedEvent;
import com.demo.orderService.repository.OrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;
    private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;

    public void placeOrder(OrderRequest orderRequest) {
        boolean isInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());
        if(isInStock) {
            Order order = Order.builder().orderNumber(UUID.randomUUID().toString())
                    .skuCode(orderRequest.skuCode())
                    .price(orderRequest.price().multiply(BigDecimal.valueOf(orderRequest.quantity())))
                    .quantity(orderRequest.quantity())
                    .build();

            orderRepository.save(order);
            log.info("Order {} is saved", order.getId());

            OrderPlacedEvent orderPlacedEvent = new OrderPlacedEvent();
            orderPlacedEvent.setOrderNumber(order.getOrderNumber());
            orderPlacedEvent.setEmail(orderRequest.userDetails().email());
            log.info("Start - Sending order details to Kafka topic order-placed");
            kafkaTemplate.send("order-placed",orderPlacedEvent);
            log.info("End - Sending order details to Kafka topic order-placed");
        } else {
            throw new IllegalArgumentException("Product is not in stock, please try again later");
        }

    }

}
