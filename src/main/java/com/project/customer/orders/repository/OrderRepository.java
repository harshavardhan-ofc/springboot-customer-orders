// repository/OrderRepository.java
package com.project.customer.orders.repository;

import com.project.customer.orders.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
  // Find orders by customer id
  List<Order> findByCustomerId(Long customerId);
}
