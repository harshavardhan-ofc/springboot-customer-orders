package com.project.customer.orders.controller;

import com.project.customer.orders.dto.CustomerDTO;
import com.project.customer.orders.exception.ResourceNotFoundException;
import com.project.customer.orders.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long customerId) {
        return customerService.getCustomerById(customerId)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + customerId));
    }

    @PostMapping
    public ResponseEntity<List<CustomerDTO>> saveCustomers(@RequestBody List<CustomerDTO> customers) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.saveCustomers(customers));
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long customerId) {
        if (customerService.getCustomerById(customerId).isEmpty()) {
            throw new ResourceNotFoundException("Customer not found with id " + customerId);
        }
        customerService.deleteCustomer(customerId);
        return ResponseEntity.ok("successfully deleted ");
    }
}
