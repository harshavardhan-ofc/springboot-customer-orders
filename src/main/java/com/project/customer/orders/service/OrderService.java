package com.project.customer.orders.service;

import com.project.customer.orders.dto.OrderDTO;
import com.project.customer.orders.entity.Order;
import java.util.List;

public interface OrderService {

    List<OrderDTO> getAllOrders();

    List<OrderDTO> getOrdersByCustomerId(Long customerId);

    OrderDTO saveOrder(OrderDTO orderDto);

    // Mapping methods
    OrderDTO entityToDto(Order order);
    Order dtoToEntity(OrderDTO orderDto);
}
