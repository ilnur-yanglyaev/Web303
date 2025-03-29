package org.example.lab_2.controller;

import lombok.AllArgsConstructor;
import org.example.lab_2.domain.dto.manufacturer.ManufacturerInfoDto;
import org.example.lab_2.domain.entity.Category;
import org.example.lab_2.domain.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.example.lab_2.service.impl.CustomerServiceImpl;

import java.util.List;

@AllArgsConstructor
@RestController("/api/v1")
public class CustomerController {

    private final CustomerServiceImpl customerService;

    @GetMapping("/customer/{customerId}/purchases")
    public ResponseEntity<ManufacturerInfoDto> getAllPurchasesForCustomer() {
        return null;

    }


    @GetMapping("/purchases/customersInfo")
    public ResponseEntity<ManufacturerInfoDto> getCustomersInfo() {
        return null;

    }

    @GetMapping("/test")
    List<Category> getCategory() {
        return customerService.getCategory();
    }

    @GetMapping("/test1")
    List<Product> getProducts() {
        return customerService.getProducts();
    }


}
