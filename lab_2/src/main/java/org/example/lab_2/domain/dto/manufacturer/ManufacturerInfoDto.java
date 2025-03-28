package org.example.lab_2.domain.dto.manufacturer;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManufacturerInfoDto {
    private Long total;
    private List<ManufacturerDataDto> manufacturerDataDtoList;
}
