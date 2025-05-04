package org.example.lab_2.controller.generated;


import org.example.lab_2.domain.dto.customer.CustomerPurchaseDto;
import org.example.lab_2.domain.dto.customer.CustomerPurchaseItemDto;
import org.example.lab_2.domain.entity.Customer;
import org.example.lab_2.model.rest.model.*;
import org.example.lab_2.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.example.lab_2.model.rest.controller.api.CustomerApiApi;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CustomerApiController implements CustomerApiApi {

    private final CustomerRepository customerRepository;

    public CustomerApiController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public ResponseEntity<CustomerPurchasesDto> apiV1CustomerCustomerIdPurchasesGet(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
        // Создаем DTO покупателя
        CustomerDto customerDto = new CustomerDto()
                .id(customer.getId())
                .name(customer.getFirstName())
                .secondName(customer.getLastName());

//        List<PurchaseDto>purchases= customerRepository.;

        List<Object[]> purchaseData = customerRepository.getCustomerPurchaseData(customerId);
        List<PurchaseDto> purchases = new ArrayList<>();
        PurchaseDto currentPurchase = null;
        for (Object[] row : purchaseData) {
            Long purchaseId = ((Integer) row[0]).longValue();
            Timestamp timestamp = (Timestamp) row[1];
            LocalDateTime purchaseDate = timestamp.toLocalDateTime();
            String productName = (String) row[2];
            Integer count = (Integer) row[3];
            BigDecimal price = (BigDecimal) row[4];
            BigDecimal totalPrice = (BigDecimal) row[5];

            if (currentPurchase == null || !currentPurchase.getId().equals(purchaseId)) {
                currentPurchase = new PurchaseDto();
                currentPurchase.setId(purchaseId);
                currentPurchase.setPurchaseDate(purchaseDate);
                currentPurchase.setItemList(new ArrayList<>());
                purchases.add(currentPurchase);
            }

            PurchaseItemDto itemDto = new PurchaseItemDto();
            itemDto.setProductName(productName);
            itemDto.setCount(count);
            itemDto.setPrice(price);
            itemDto.setTotalPrice(totalPrice);

            currentPurchase.getItemList().add(itemDto);
        }



        // Собираем ответ
        CustomerPurchasesDto response = new CustomerPurchasesDto()
                .customer(customerDto)
                .purchiseList(purchases);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<CustomersInfoDto> apiV1PurchasesCustomersInfoGet() {
        List<CustomerInfoDto> customerList = customerRepository.findCustomersWithPurchaseGen()
                .stream()
                .map(info -> new CustomerInfoDto()
                        .name(info.getName())
                        .secondName(info.getSecondName())
                        .purchaseCount(info.getPurchaseCount()))
                .collect(Collectors.toList());

        CustomersInfoDto custInf = new CustomersInfoDto();
        custInf.setCustomerList(customerList);
        return ResponseEntity.ok(custInf);
    }
}