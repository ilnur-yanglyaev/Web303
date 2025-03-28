package com.example.service;

import com.example.exception.*;
import com.example.model.ErrorDto;
import com.example.utils.RequestUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class CommonExceptionHandler {

    @Autowired
    private HttpServletRequest request;

    // Обработка NotFoundApiException (ресурс не найден)
    @ExceptionHandler(NotFoundApiException.class)
    public ResponseEntity<ErrorDto> handleNotFoundApiException(NotFoundApiException ex) {
        log.warn("Resource not found: {}", ex.getMessage(), ex);

        ErrorDto errorDto = new ErrorDto(
                RequestUtils.getXRequestIdHeader(request), // Извлекаем ID запроса
                ex.getCode(),
                ex.getMessage(),
                ex.getDescription()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDto);
    }

    // Обработка BadRequestApiException (ошибка валидации входных параметров)
    @ExceptionHandler(BadRequestApiException.class)
    public ResponseEntity<ErrorDto> handleBadRequestApiException(BadRequestApiException ex) {
        log.warn("Bad request: {}", ex.getMessage(), ex);

        ErrorDto errorDto = new ErrorDto(
                RequestUtils.getXRequestIdHeader(request),
                ex.getCode(),
                ex.getMessage(),
                ex.getDescription()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
    }

    // Обработка ConflictApiException (логические конфликты)
    @ExceptionHandler(ConflictApiException.class)
    public ResponseEntity<ErrorDto> handleConflictApiException(ConflictApiException ex) {
        log.warn("Conflict occurred: {}", ex.getMessage(), ex);

        ErrorDto errorDto = new ErrorDto(
                RequestUtils.getXRequestIdHeader(request),
                ex.getCode(),
                ex.getMessage(),
                ex.getDescription()
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDto);
    }

    // Обработка InternalApiException (внутренние ошибки)
    @ExceptionHandler(InternalApiException.class)
    public ResponseEntity<ErrorDto> handleInternalApiException(InternalApiException ex) {
        log.error("Internal server error: {}", ex.getMessage(), ex);

        ErrorDto errorDto = new ErrorDto(
                RequestUtils.getXRequestIdHeader(request),
                ex.getCode(),
                ex.getMessage(),
                ex.getDescription()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDto);
    }

    // Обработка всех остальных исключений
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleGenericException(Exception ex) {
        log.error("Unexpected exception occurred: {}", ex.getMessage(), ex);

        ErrorDto errorDto = new ErrorDto(
                RequestUtils.getXRequestIdHeader(request),
                "internal_error",
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                "Произошла непредвиденная ошибка"
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDto);
    }
}