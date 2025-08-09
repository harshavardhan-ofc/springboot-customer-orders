// dto/CustomerDTO.java
package com.project.customer.orders.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class CustomerDTO {

    private Long id;

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name can be up to 100 characters")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    private List<OrderDTO> orders; // if needed

    // Getters and setters
}
