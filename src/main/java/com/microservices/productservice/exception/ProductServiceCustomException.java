package com.microservices.productservice.exception;

public class ProductServiceCustomException extends RuntimeException {
    private final int errorCode;

    public ProductServiceCustomException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
