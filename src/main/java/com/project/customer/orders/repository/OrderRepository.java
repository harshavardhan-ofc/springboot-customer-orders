package com.project.customer.orders.repository;

import com.project.customer.orders.dto.OrderDTO;
import com.project.customer.orders.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
  List<Order> findByCustomerId(Long customerId);
}
