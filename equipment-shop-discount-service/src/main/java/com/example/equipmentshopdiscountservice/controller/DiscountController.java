package com.example.equipmentshopdiscountservice.controller;

import org.example.equipment_shop_discount_service.api.CategoryDiscountInfoApi;
import org.example.equipment_shop_discount_service.model.CategoryDiscountInfoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Optional;

@RestController
public class DiscountController implements CategoryDiscountInfoApi {
    // Статическая структура данных для хранения категорий и скидок
    private static final CategoryDiscountInfoDto[] CATEGORY_DISCOUNTS = {
            createDiscountDto(1L, 5L),
            createDiscountDto(2L, 10L),
            createDiscountDto(3L, 0L),
            createDiscountDto(4L, 15L),
            createDiscountDto(5L, 7L)
    };


    @Override
    public ResponseEntity<CategoryDiscountInfoDto> apiV1CategoryIdDiscountGet(Long categoryId) {
        // Ищем категорию в нашем "хранилище"
        Optional<CategoryDiscountInfoDto> discountInfo = Arrays.stream(CATEGORY_DISCOUNTS)
                .filter(dto -> dto.getCategoryId().equals(categoryId))
                .findFirst();

        if (discountInfo.isPresent()) {
            return ResponseEntity.ok(discountInfo.get());
        } else {
            // Если категория не найдена, возвращаем DTO с discount = 0
            return ResponseEntity.ok(createDiscountDto(categoryId, 0L));
        }
    }

    // Вспомогательный метод для создания DTO
    private static CategoryDiscountInfoDto createDiscountDto(Long categoryId, Long discount) {
        CategoryDiscountInfoDto dto = new CategoryDiscountInfoDto();
        dto.setCategoryId(categoryId);
        dto.setDiscount(discount);
        return dto;
    }
}