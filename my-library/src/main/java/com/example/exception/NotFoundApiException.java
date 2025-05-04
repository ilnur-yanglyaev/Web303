package com.example.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundApiException extends BaseApiException {
    private static final String DEFAULT_MESSAGE = "Ресурс не найден";
    private static final String DEFAULT_DESCRIPTION = "Запрашиваемый ресурс не существует.";

    public NotFoundApiException() {
        super("not_found", DEFAULT_MESSAGE, DEFAULT_DESCRIPTION);
    }

}
