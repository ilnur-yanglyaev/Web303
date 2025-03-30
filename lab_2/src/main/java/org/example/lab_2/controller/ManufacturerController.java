package org.example.lab_2.controller;

import lombok.AllArgsConstructor;
import org.example.lab_2.domain.dto.manufacturer.ManufacturerInfoDto;
import org.example.lab_2.service.impl.ManufacturerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.lab_2.domain.dto.manufacturer.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class ManufacturerController {

    @Autowired
    private final ManufacturerServiceImpl manufacturerService;

    @GetMapping("/manufacturerStatistic")
    public ResponseEntity<ManufacturerInfoDto> getManufacturerInfo() {
        ManufacturerInfoDto manufacturerInfo = manufacturerService.getManufacturerInfo();
        return ResponseEntity.ok(manufacturerInfo);
    }

    @GetMapping("/total")
    public ResponseEntity<Long> getTotal() {
       Long manufacturerInfo = manufacturerService.getTotal();
        return ResponseEntity.ok(manufacturerInfo);
    }
}
