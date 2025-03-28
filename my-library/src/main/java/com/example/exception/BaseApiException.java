package com.example.exception;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class BaseApiException extends RuntimeException {
    private final String code;
    private final String message;
    private final String description;


    protected BaseApiException (String code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }
}