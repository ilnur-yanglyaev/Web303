package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDto {
    private String id;          // Уникальный идентификатор запроса
    private String code;        // Код ошибки
    private String message;     // Сообщение об ошибке
    private String description; // Подробное описание
}