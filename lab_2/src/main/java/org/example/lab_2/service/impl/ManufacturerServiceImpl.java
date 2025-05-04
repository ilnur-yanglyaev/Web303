package org.example.lab_2.service.impl;

import lombok.AllArgsConstructor;
import org.example.lab_2.domain.dto.manufacturer.ManufacturerDataDto;
import org.example.lab_2.domain.dto.manufacturer.ManufacturerInfoDto;
import org.example.lab_2.repository.ManufacturerRepository;
import org.springframework.stereotype.Service;

import com.example.exception.*;


import java.util.List;

@Service
@AllArgsConstructor
public class ManufacturerServiceImpl {

    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerInfoDto getManufacturerInfo() {
        List<ManufacturerDataDto> manufacturerData = manufacturerRepository.getManufacturerData();

        if (manufacturerData.isEmpty()) {
            throw new NotFoundApiException();
        }
        Long totalSales = manufacturerRepository.getTotal();

        return new ManufacturerInfoDto(totalSales, manufacturerData);
    }


    public Long getTotal() {
        Long totalSales = manufacturerRepository.getTotal();
        return totalSales;
    }
}
