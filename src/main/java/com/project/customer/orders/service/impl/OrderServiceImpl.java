package com.project.customer.orders.service.impl;

import com.project.customer.orders.dto.OrderDTO;
import com.project.customer.orders.entity.Customer;
import com.project.customer.orders.exception.ResourceNotFoundException;
import com.project.customer.orders.entity.Order;
import com.project.customer.orders.entity.Order;
import com.project.customer.orders.repository.CustomerRepository;
import com.project.customer.orders.repository.OrderRepository;
import com.project.customer.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream().map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getOrdersByCustomerId(Long customerId) {
        return orderRepository.findByCustomerId(customerId)
                .stream().map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO saveOrder(OrderDTO orderDto) {
        Order order = dtoToEntity(orderDto);
        Order saved = orderRepository.save(order);
        return entityToDto(saved);
    }

    @Override
    public OrderDTO entityToDto(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setProduct(order.getProduct());
        dto.setQuantity(order.getQuantity());
        dto.setOrderDate(order.getOrderDate());
        dto.setCustomerId(order.getCustomer().getId());
        return dto;
    }

    @Override
    public Order dtoToEntity(OrderDTO dto) {
        Order order = new Order();
        order.setId(dto.getId());
        order.setProduct(dto.getProduct());
        order.setQuantity(dto.getQuantity());
        if (dto.getOrderDate() != null) {
            order.setOrderDate(dto.getOrderDate());
        } else {
            order.setOrderDate(LocalDateTime.now());
        }

        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + dto.getCustomerId()));
        order.setCustomer(customer);
        return order;
    }
}
