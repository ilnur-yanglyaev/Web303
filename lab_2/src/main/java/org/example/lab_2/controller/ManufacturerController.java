package org.example.lab_2.controller;

import org.example.lab_2.domain.dto.manufacturer.ManufacturerInfoDto;
import org.springframework.http.ResponseEntity;
import org.example.lab_2.service.ManufacturerService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController("/api/v2")
public class ManufacturerController {

//    @Autowired
//    private final ManufacturerService manufacturerService;

    @GetMapping("/manufacturerStatistic")
    public ResponseEntity<ManufacturerInfoDto> getManufacturerInfo() {
        return null;

    }
}
