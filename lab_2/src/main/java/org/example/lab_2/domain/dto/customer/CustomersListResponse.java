package org.example.lab_2.domain.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomersListResponse {
    private List<CustomersInfoDto> customerList;
}
