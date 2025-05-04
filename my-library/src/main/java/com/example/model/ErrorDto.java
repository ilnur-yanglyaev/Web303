package com.example.model;

import com.example.exception.BaseApiException;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
public class ErrorDto {
    private String id ;
    private String code;
    private String message;
    private String description;

    public ErrorDto(String code, String message, String description) {
        this.id = UUID.randomUUID().toString();
        this.code = code;
        this.message = message;
        this.description = description;
    }
}