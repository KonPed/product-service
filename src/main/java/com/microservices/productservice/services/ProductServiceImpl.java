package com.microservices.productservice.services;

import com.microservices.productservice.entities.Converter;
import com.microservices.productservice.entities.ProductEntity;
import com.microservices.productservice.exception.ProductServiceCustomException;
import com.microservices.productservice.model.Product;
import com.microservices.productservice.repositories.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


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
    public Product getProductById(Long id) {
        log.info("=> Getting product by id: {}", id);
        return productRepository.findById(id)
                .map(Converter::convertFromEntity)
                .orElseThrow(() -> new ProductServiceCustomException("Product with id " + id + " not found", HttpStatus.NOT_FOUND.value()));
    }

    @Override
    public Long addProduct(Product product) {
        ProductEntity productEntity = Converter.convertToEntity(product);
        log.info("=> Adding product: {}", productEntity);
        productRepository.save(productEntity);
        log.info("=> Product Added: {}", productEntity);
        return productEntity.getProductId();
    }

    @Override
    public void reduceQuantity(Long productId, Long quantity) {
        log.info("=> Reduce quantity: {} for productId: {}", quantity, productId);
        ProductEntity productEntity = productRepository.findById(productId)
                .orElseThrow(() -> new ProductServiceCustomException("Product with id " + productId + " not found", HttpStatus.NOT_FOUND.value()));

        if (productEntity.getQuantity() < quantity) {
            throw new ProductServiceCustomException("Product does not have enough quantity", HttpStatus.NOT_ACCEPTABLE.value());
        }

        productEntity.setQuantity(productEntity.getQuantity() - quantity);
        productRepository.save(productEntity);
        log.info("=> Product: {}, reduced by: {}", productEntity, quantity);
    }
}
