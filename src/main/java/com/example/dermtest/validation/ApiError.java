package com.example.dermtest.validation;

import lombok.Data;
@Data
public class ApiError {
    private String message;
    private Integer errorCode;
}
