package com.example.exception;

public class NotFoundApiException extends BaseApiException {
    public NotFoundApiException(String message, String description) {
        super("not_found", message, description);
    }
}