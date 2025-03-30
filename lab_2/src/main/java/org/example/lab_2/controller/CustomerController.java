package org.example.lab_2.controller;

import lombok.AllArgsConstructor;
//import org.example.lab_2.domain.dto.customer.CustomerInfoDto;
import org.example.lab_2.domain.dto.customer.CustomerInfoDto;
import org.example.lab_2.domain.dto.customer.CustomersInfoDto;
import org.example.lab_2.domain.dto.customer.CustomersListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.example.lab_2.service.impl.CustomerServiceImpl;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    @Autowired
    private final CustomerServiceImpl customerService;

    @GetMapping("/customer/{customerId}/purchases")
    public ResponseEntity<CustomerInfoDto> getAllPurchasesForCustomer(@PathVariable Long customerId) {
        CustomerInfoDto customerInfo = customerService.getCustomerInfo(customerId);
        return ResponseEntity.ok(customerInfo);
    }


    @GetMapping("/purchases/customersInfo")
    public ResponseEntity<CustomersListResponse> getCustomersInfo() {
        List<CustomersInfoDto> customerList=customerService.getAllCustomerWithPurchase();
        CustomersListResponse customerListResponse=new CustomersListResponse(customerList);
        return ResponseEntity.ok(customerListResponse);
    }

}
