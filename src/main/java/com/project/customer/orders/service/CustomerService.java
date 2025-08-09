package com.project.customer.orders.service;

import com.project.customer.orders.dto.CustomerDTO;
import com.project.customer.orders.entity.Customer; // Add this import
import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
    Optional<CustomerDTO> getCustomerById(Long id);
    List<CustomerDTO> saveCustomers(List<CustomerDTO> customers); // Bulk insert
    void deleteCustomer(Long id);

    // Mapping methods
    CustomerDTO entityToDto(Customer customer);
    Customer dtoToEntity(CustomerDTO customerDto);
}
