package com.microservices.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String errorMessage;
    private int errorCode;
    private HttpStatus status;
}
