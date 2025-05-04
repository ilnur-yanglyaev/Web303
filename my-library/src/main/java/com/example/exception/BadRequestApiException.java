package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestApiException extends BaseApiException {
    private static final String DEFAULT_MESSAGE = "Ошибка валидации входных параметров";
    private static final String DEFAULT_DESCRIPTION = "Параметры запроса не соответствуют требованиям,ошибки внутри метода.";

    public BadRequestApiException() {
        super("bad_request", DEFAULT_MESSAGE, DEFAULT_DESCRIPTION);
    }

}
