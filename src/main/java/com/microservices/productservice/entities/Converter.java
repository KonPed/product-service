package com.microservices.productservice.entities;

import com.microservices.productservice.model.Product;

public class Converter {

    public static ProductEntity convertToEntity(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductName(product.getProductName());
        productEntity.setPrice(product.getPrice());
        productEntity.setQuantity(product.getQuantity());
        return productEntity;
    }

    public static Product convertFromEntity(ProductEntity productEntity) {
        Product product = new Product();
        product.setProductName(productEntity.getProductName());
        product.setPrice(productEntity.getPrice());
        product.setQuantity(productEntity.getQuantity());
        return product;
    }
}
