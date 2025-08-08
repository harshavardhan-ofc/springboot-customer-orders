package com.project.customer.orders.service.impl;
import com.project.customer.orders.dto.OrderDTO;
import com.project.customer.orders.entity.Customer;
import com.project.customer.orders.entity.Order;
import com.project.customer.orders.exception.ResourceNotFoundException;
import com.project.customer.orders.repository.CustomerRepository;
import com.project.customer.orders.repository.OrderRepository;
import com.project.customer.orders.service.CustomerService;
import com.project.customer.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderService orderService;

    @Override
    public List<OrderDTO> getOrdersByCustomerId(Long customerId) {
        return orderService.getOrdersByCustomerId(customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        return customer.orElse(null);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        // Set 'customer' in each order to ensure foreign key is correctly saved
        if (customer.getOrders() != null) {
            for (Order order : customer.getOrders()) {
                order.setCustomer(customer);
            }
        }
        return customerRepository.save(customer);
    }
//    Customer customer = customerRepository.findById(customerId)
//            .orElseThrow(() -> new ResourceNotFoundException("Customer not found with ID: " + customerId));


}
