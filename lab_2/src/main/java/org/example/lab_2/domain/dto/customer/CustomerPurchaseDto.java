package org.example.lab_2.domain.dto.customer;

import lombok.*;

import java.sql.Timestamp;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerPurchaseDto {
    private Long id;
    private Timestamp purchaseDate;
    private List<CustomerPurchaseItemDto> itemList;
}