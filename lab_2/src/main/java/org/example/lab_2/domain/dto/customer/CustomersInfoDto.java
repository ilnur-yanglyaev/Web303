package org.example.lab_2.domain.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomersInfoDto {
    private String name;
    private String secondName;
    private Long purchaseCount;
}