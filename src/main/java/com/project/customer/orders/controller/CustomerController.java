package com.project.customer.orders.controller;

import com.project.customer.orders.dto.OrderDTO;
import com.project.customer.orders.entity.Customer;
import com.project.customer.orders.entity.Order;
import com.project.customer.orders.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //  GET all customers
    @GetMapping("/getAll")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    //  GET a customer by ID
    @GetMapping("get/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }

    //  GET all orders for a customer
    @GetMapping("/{customerId}/orders")
    public ResponseEntity<List<OrderDTO>> getOrdersByCustomerId(@PathVariable Long customerId) {
        List<OrderDTO> orders=customerService.getOrdersByCustomerId(customerId);
        return ResponseEntity.ok(orders);
    }

    //  POST a new customer (optional)
    @PostMapping("/post")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.saveCustomer(customer));
    }

    @PostMapping("post/with-orders")
    public ResponseEntity<Customer> createCustomerWithOrders(@RequestBody Customer customer) {
        // Set the customer for each order
        if (customer.getOrders() != null) {
            for (Order order : customer.getOrders()) {
                order.setCustomer(customer);
            }
        }

        Customer savedCustomer = customerService.saveCustomer(customer);
        return ResponseEntity.ok(savedCustomer);
    }
}