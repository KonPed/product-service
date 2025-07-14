package com.microservices.productservice.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "PRODUCT")
@Data
public class ProductEntity {

    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRICE")
    private long price;

    @Column(name = "QUANTITY")
    private long quantity;

}
