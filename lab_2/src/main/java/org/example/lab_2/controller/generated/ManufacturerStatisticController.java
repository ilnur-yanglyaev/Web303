package org.example.lab_2.controller.generated;

import org.example.lab_2.model.rest.controller.api.ManufacturerStatisticApi;
import org.example.lab_2.model.rest.model.ManufacturerStatisticDto;
import org.example.lab_2.model.rest.model.ManufacturerStatisticDtoManufacturerListInner;
import org.example.lab_2.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ManufacturerStatisticController implements ManufacturerStatisticApi {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Override
    public ResponseEntity<ManufacturerStatisticDto> apiV1ManufacturerStatisticGet() {
        Long total = manufacturerRepository.getTotal();
//        List<ManufacturerStatisticDtoManufacturerListInner> manufacturerData = manufacturerRepository.getManufacturerInnerData();
        List<ManufacturerStatisticDtoManufacturerListInner> manufacturerData = manufacturerRepository.getManufacturerStats()
                .stream()
                .map(projection -> {
                    ManufacturerStatisticDtoManufacturerListInner item = new ManufacturerStatisticDtoManufacturerListInner();
                    item.setManufacturerName(projection.getManufacturerName());
                    item.setCount(projection.getCount());
                    item.setPercent(BigDecimal.valueOf(projection.getPercent()));
                    return item;
                })
                .collect(Collectors.toList());



        ManufacturerStatisticDto dto = new ManufacturerStatisticDto();
        dto.setTotal(total);
        dto.setManufacturerList(manufacturerData);

        return ResponseEntity.ok(dto);
    }

}