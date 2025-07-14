package com.microservices.productservice.model;

import lombok.Data;

@Data
public class Product {
    private String productName;
    private long price;
    private long quantity;
}
