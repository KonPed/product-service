package com.microservices.productservice.services;

import com.microservices.productservice.entities.Converter;
import com.microservices.productservice.entities.ProductEntity;
import com.microservices.productservice.model.Product;
import com.microservices.productservice.repositories.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        log.info("=> Getting all products");
        List<ProductEntity> productEntities = productRepository.findAll();
        return productEntities.stream()
                .map(Converter::convertFromEntity)
                .toList();
    }

    @Override
    public Long addProduct(Product product) {
        ProductEntity productEntity = Converter.convertToEntity(product);
        log.info("=> Adding product: {}", productEntity);
        productRepository.save(productEntity);
        log.info("=> Product Added: {}", productEntity);
        return productEntity.getProductId();
    }
}
