// repository/CustomerRepository.java
package com.project.customer.orders.repository;

import com.project.customer.orders.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
