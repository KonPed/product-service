package com.microservices.productservice.services;

import com.microservices.productservice.model.Product;

import java.util.List;

public interface ProductService {
    Long addProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(Long id);

    void reduceQuantity(Long productId, Long quantity);
}
