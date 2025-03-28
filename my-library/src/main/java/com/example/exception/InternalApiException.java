package com.example.exception;

public class InternalApiException extends BaseApiException {
    public InternalApiException(String message, String description) {
        super("internal_error", message, description);
    }
}