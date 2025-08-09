// dto/OrderDTO.java
package com.project.customer.orders.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDTO {

    private Long id;

    @NotBlank(message = "product name is required")
    private String product;

    @Positive(message = "Quantity must be positive")
    @NotNull(message = "Quantity is required")
    private Integer quantity;

    private LocalDateTime orderDate;

    @NotNull(message = "Customer id is required")
    private Long customerId;
    // Getters and setters
}
