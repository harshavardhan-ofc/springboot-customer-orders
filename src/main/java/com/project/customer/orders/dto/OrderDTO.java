package com.project.customer.orders.dto;

import lombok.Data;

@Data
public class OrderDTO {
    private Long id;
    private String productName;
    private Double price;

    public OrderDTO(Long id, String productName,Double price){
        this.id=id;
        this.productName=productName;
        this.price=price;
    }
}
