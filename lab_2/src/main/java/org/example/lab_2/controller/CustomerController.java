package org.example.lab_2.controller;

import com.example.exception.BadRequestApiException;
import com.example.exception.ConflictApiException;
import com.example.exception.InternalApiException;
import com.example.exception.NotFoundApiException;
import lombok.AllArgsConstructor;
//import org.example.lab_2.domain.dto.customer.CustomerInfoDto;
import org.example.lab_2.domain.dto.customer.CustomerInfoDto;
import org.example.lab_2.domain.dto.customer.CustomersInfoDto;
import org.example.lab_2.domain.dto.customer.CustomersListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.lab_2.service.impl.CustomerServiceImpl;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/mapi/v1")
public class CustomerController {

    @Autowired
    private final CustomerServiceImpl customerService;

    @GetMapping("/customer/{customerId}/purchases")
//    public ResponseEntity<CustomerInfoDto> getAllPurchasesForCustomer(@PathVariable Long customerId) {
//        CustomerInfoDto customerInfo = customerService.getCustomerInfo(customerId);
//        return ResponseEntity.ok(customerInfo);
//    }
    public ResponseEntity<CustomerInfoDto> getAllPurchasesForCustomer(@PathVariable String customerId) {
        try {
            Long parsedCustomerId = Long.parseLong(customerId);
            CustomerInfoDto customerInfo = customerService.getCustomerInfo(parsedCustomerId);
            return ResponseEntity.ok(customerInfo);
        } catch (NumberFormatException ex) {
            throw new BadRequestApiException();
        }
    }

    @GetMapping("/purchases/customersInfo")
    public ResponseEntity<CustomersListResponse> getCustomersInfo() {
        List<CustomersInfoDto> customerList=customerService.getAllCustomerWithPurchase();
        CustomersListResponse customerListResponse=new CustomersListResponse(customerList);
        return ResponseEntity.ok(customerListResponse);
    }


//    @DeleteMapping("/customer")
//    public ResponseEntity<String> deleteCustomer(@RequestParam Long id) {
//        Customer customer = CustomerServiceImpl.getCustomerById(id);
//
//        if (customer != null) {
//            CustomerServiceImpl.deleteCustomer(id);
//            return ResponseEntity.ok("Студент успешно удалён.");
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" не найден.");
//        }
//    }

    @GetMapping("/not")
    public ResponseEntity checkNot(){
        throw new NotFoundApiException();
    }
    @GetMapping("/conflict")
    public ResponseEntity<?> checkConflict(){
        throw new ConflictApiException();
    }
    @GetMapping("/badreq")
    public ResponseEntity<?> checkBadReq(){
        throw new BadRequestApiException();
    }
    @GetMapping("/internal")
    public ResponseEntity<?> checkInternal(){
        throw new InternalApiException();
    }
}
