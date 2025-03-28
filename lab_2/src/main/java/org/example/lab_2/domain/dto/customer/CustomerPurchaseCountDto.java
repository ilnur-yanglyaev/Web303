package org.example.lab_2.domain.dto.customer;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerPurchaseCountDto {
    private String name;
    private String secondName;
    private Long purchaseCount;
}