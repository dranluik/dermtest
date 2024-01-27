package com.example.dermtest.validation;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DataNotFoundException extends RuntimeException {
    private final String message;
    private final Integer errorCode;

    public DataNotFoundException(String message, Integer errorCode) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }
}