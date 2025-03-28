package org.example.lab_2.domain.dto.customer;

import lombok.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomersInfoDto {
    private List<CustomerPurchaseCountDto> customerList;
}