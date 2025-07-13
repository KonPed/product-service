package com.microservices.productservice.model;

import lombok.Data;

@Data
public class Product {

    private long productId;
    private String productName;
    private long price;
    private long quantity;
}
