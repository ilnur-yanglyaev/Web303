package org.example.lab_2.domain.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerPurchaseItemDto {
    private String productName;
    private Integer count;
    private BigDecimal price;
    private BigDecimal totalPrice;
}
