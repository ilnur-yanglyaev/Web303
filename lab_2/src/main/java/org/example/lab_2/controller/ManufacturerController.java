package org.example.lab_2.controller;

import org.example.lab_2.domain.dto.manufacturer.ManufacturerInfoDto;
import org.springframework.http.ResponseEntity;
import org.example.lab_2.service.ManufacturerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    @GetMapping("/api/v1/manufacturerStatistic")
    public ResponseEntity<ManufacturerInfoDto> getManufacturerInfo() {
        return null;

    }
}
