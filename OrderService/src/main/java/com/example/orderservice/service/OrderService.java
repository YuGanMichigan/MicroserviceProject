package com.example.orderservice.service;

import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.entity.Order;
import com.example.orderservice.entity.OrderLineItem;
import com.example.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    public Order placeOrder(OrderRequest orderRequest) {

        Order order = new Order();
        List<OrderLineItem> orderLineItems = orderRequest.getOrderItemDtolist()
                .stream()
                .map(a -> modelMapper.map(a, OrderLineItem.class))
                .toList();
        order.setOrderLineItem(orderLineItems);
        System.out.println(order);
        Order savedOrder = orderRepository.save(order);
        return savedOrder;
    }
}
