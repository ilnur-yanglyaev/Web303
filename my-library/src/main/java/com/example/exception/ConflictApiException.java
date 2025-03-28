package com.example.exception;

public class ConflictApiException extends BaseApiException {
    public ConflictApiException(String message, String description) {
        super("conflict", message, description);
    }
}