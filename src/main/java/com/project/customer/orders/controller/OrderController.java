package com.project.customer.orders.controller;

import com.project.customer.orders.dto.OrderDTO;
import com.project.customer.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDTO> getOrders(@RequestParam(value = "customerId", required = false) Long customerId) {
        if (customerId != null) {
            return orderService.getOrdersByCustomerId(customerId);
        }
        return orderService.getAllOrders();
    }

    @PostMapping("/post")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTO orderDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.saveOrder(orderDTO));
    }
}
