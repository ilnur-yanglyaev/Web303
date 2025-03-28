package org.example.lab_2.domain.dto.manufacturer;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManufacturerDataDto {
    private String manufacturerName;
    private Long count;
    private Double percent;
}
