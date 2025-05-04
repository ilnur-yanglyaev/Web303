package com.example.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictApiException extends BaseApiException {
    private static final String DEFAULT_MESSAGE = "Логический конфликт";
    private static final String DEFAULT_DESCRIPTION = "Произошел конфликт в логике обработки запроса, внутри методов сервиса.";

    public ConflictApiException() {
        super("conflict", DEFAULT_MESSAGE, DEFAULT_DESCRIPTION);
    }
}
