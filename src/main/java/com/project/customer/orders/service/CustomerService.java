package com.project.customer.orders.service;

import com.project.customer.orders.dto.OrderDTO;
import com.project.customer.orders.entity.Customer;
import com.project.customer.orders.entity.Order;

import java.util.List;


public interface CustomerService {
    List<OrderDTO> getOrdersByCustomerId(Long customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerById(Long customerId);

    Customer saveCustomer(Customer customer);
}
