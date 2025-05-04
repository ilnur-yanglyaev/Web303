package org.example.lab_2.service.impl;

import com.example.exception.NotFoundApiException;
import lombok.AllArgsConstructor;
import org.example.lab_2.domain.dto.customer.CustomerInfoDto;
import org.example.lab_2.domain.dto.customer.CustomerPurchaseDto;
import org.example.lab_2.domain.dto.customer.CustomerPurchaseItemDto;
import org.example.lab_2.domain.dto.customer.CustomersInfoDto;
import org.example.lab_2.domain.dto.manufacturer.ManufacturerDataDto;
import org.example.lab_2.domain.entity.Customer;
import org.example.lab_2.repository.CustomerRepository;
import org.example.lab_2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.exception.*;

@Service
@AllArgsConstructor
public class CustomerServiceImpl
implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerInfoDto getCustomerInfo(Long customerId) {
        try {
            Customer customer = customerRepository.findById(customerId)
                    .orElseThrow(() -> new NotFoundApiException());

            List<Object[]> purchaseData = customerRepository.getCustomerPurchaseData(customerId);
            List<CustomerPurchaseDto> customerPurchaseData = new ArrayList<>();
            CustomerPurchaseDto currentPurchase = null;
            for (Object[] row : purchaseData) {
                Long purchaseId = ((Integer) row[0]).longValue();
                Timestamp purchaseDate = (Timestamp) row[1];

                String productName = (String) row[2];
                Integer count = (Integer) row[3];
                BigDecimal price = (BigDecimal) row[4];
                BigDecimal totalPrice = (BigDecimal) row[5];

                if (currentPurchase == null || !currentPurchase.getId().equals(purchaseId)) {
                    currentPurchase = new CustomerPurchaseDto(purchaseId, purchaseDate, new ArrayList<>());
                    customerPurchaseData.add(currentPurchase);
                }
                currentPurchase.getItemList().add(new CustomerPurchaseItemDto(productName, count, price, totalPrice));
            }

            return new CustomerInfoDto(customer, customerPurchaseData);
        }
        catch (DataAccessException ex) {
            throw new InternalApiException();
        }
    }


    public List<CustomersInfoDto> getAllCustomerWithPurchase() {
        return (customerRepository.findCustomersWithPurchase());
    }



    @Override
    public Customer getCustomerById(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        Customer customer=customerOptional.get();
        return customer;
    }

    @Override
    public Customer addCustomer(Customer Customer) {
        return null;
    }

    @Override
    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        return null;
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
    
    
}
