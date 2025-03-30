package org.example.lab_2.domain.dto.customer;

import lombok.*;
import org.example.lab_2.domain.entity.Customer;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerInfoDto {
    private Customer customer;
    private List<CustomerPurchaseDto> purchaseList;
}