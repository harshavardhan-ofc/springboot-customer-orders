package com.project.customer.orders.service.impl;

import com.project.customer.orders.dto.OrderDTO;
import com.project.customer.orders.entity.Order;
import com.project.customer.orders.exception.ResourceNotFoundException;
import com.project.customer.orders.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    public OrderRepository orderRepository;

    public List<OrderDTO> getOrdersByCustomerId(Long customerId) {
        List<Order> orders = orderRepository.findByCustomerId(customerId);

        if (orders == null || orders.isEmpty()) {
            throw new ResourceNotFoundException("no orders found with customer id : "+customerId);


        }
        return orders.stream()
                .map(order -> new OrderDTO(
                        order.getId(),
                        order.getProductName(),
                        order.getAmount()
                ))
                .collect(Collectors.toList());

//        example output if we hit the api which customer doesn't have any orders
//        {
//            "message": "no orders found with customer id : 2",
//                "timestamp": "2025-08-07T17:25:22.4178826",
//                "status": 404
//        }
    }
}

