package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalApiException extends BaseApiException {
    private static final String DEFAULT_MESSAGE = "Внутренняя ошибка сервера";
    private static final String DEFAULT_DESCRIPTION = "Произошла непредвиденная ошибка.";

    public InternalApiException() {
        super("internal_error", DEFAULT_MESSAGE, DEFAULT_DESCRIPTION);
    }


}
