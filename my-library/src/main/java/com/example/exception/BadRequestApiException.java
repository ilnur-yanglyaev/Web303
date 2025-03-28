package com.example.exception;

public class BadRequestApiException extends BaseApiException {
    public BadRequestApiException(String message, String description) {
        super("bad_request", message, description);
    }
}