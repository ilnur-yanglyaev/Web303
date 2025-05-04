package com.example.service;

import com.example.exception.*;
import com.example.model.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(NotFoundApiException.class)
    public ResponseEntity<ErrorDto> handleNotFoundException(NotFoundApiException ex) {
        log.warn("Resource not found: {}", ex.getMessage(), ex);
        ErrorDto errorDto = new ErrorDto(ex.getCode(), ex.getMessage(), ex.getDescription());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDto);
    }

    @ExceptionHandler(BadRequestApiException.class)
    public ResponseEntity<ErrorDto> handleBadRequestException(BadRequestApiException ex) {
        log.warn("Bad request: {}", ex.getMessage(), ex);
        ErrorDto errorDto = new ErrorDto(ex.getCode(), ex.getMessage(), ex.getDescription());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
    }

    @ExceptionHandler(ConflictApiException.class)
    public ResponseEntity<ErrorDto> handleConflictException(ConflictApiException ex) {
        log.warn("Conflict: {}", ex.getMessage(), ex);
        ErrorDto errorDto = new ErrorDto(ex.getCode(), ex.getMessage(), ex.getDescription());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDto);
    }

    @ExceptionHandler(InternalApiException.class)
    public ResponseEntity<ErrorDto> handleInternalException(InternalApiException ex) {
        log.warn("Internal server error: {}", ex.getMessage(), ex);
        ErrorDto errorDto = new ErrorDto(ex.getCode(), ex.getMessage(), ex.getDescription());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDto);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorDto> handleAllExceptions(Exception ex) {
//        ErrorDto errorDto = new ErrorDto("internal_error","Внутренняя ошибка сервера",
//                "Произошла непредвиденная ошибка");
//        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

}