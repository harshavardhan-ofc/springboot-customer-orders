package com.project.customer.orders.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="customer_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    private Double amount;

    @ManyToOne
    @JoinColumn(name="customer_id")
    @JsonIgnoreProperties("orders")
    private Customer customer;
}
