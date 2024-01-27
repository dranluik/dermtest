package com.example.dermtest.validation;
import lombok.Getter;

@Getter
public enum Error {
    DOCTOR_NOT_FOUND("Doctor not found", 111);

    private final String message;
    private final int errorCode;

    Error(String message, int errorCode){
        this.message = message;
        this.errorCode = errorCode;
    }
}
