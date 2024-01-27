package com.example.dermtest.validation;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BusinessException extends RuntimeException {
    private final String message;
    private final Integer errorCode;

    public BusinessException(String message, Integer errorCode) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }
}
