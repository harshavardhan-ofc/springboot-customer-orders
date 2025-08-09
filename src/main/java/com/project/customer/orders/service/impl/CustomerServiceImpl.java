package com.project.customer.orders.service.impl;

import com.project.customer.orders.dto.CustomerDTO;
import com.project.customer.orders.entity.Customer;
import com.project.customer.orders.repository.CustomerRepository;
import com.project.customer.orders.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll()
                .stream().map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(this::entityToDto);
    }

    @Override
    public List<CustomerDTO> saveCustomers(List<CustomerDTO> customers) {
        List<Customer> entities = customers.stream()
                .map(this::dtoToEntity)
                .collect(Collectors.toList());

        List<Customer> saved = customerRepository.saveAll(entities);
        return saved.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public CustomerDTO entityToDto(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        return dto;
    }

    @Override
    public Customer dtoToEntity(CustomerDTO dto) {
        Customer c = new Customer();
        c.setId(dto.getId());
        c.setName(dto.getName());
        c.setEmail(dto.getEmail());
        return c;
    }
}
