package org.example.lab_2.service;

import org.example.lab_2.domain.entity.Category;
import org.example.lab_2.domain.entity.Customer;
import org.example.lab_2.domain.entity.Product;

import java.util.List;

public interface CustomerService {
//    List<Customer> getAllCustomers();
    Customer getCustomerById(Long id);
    Customer addCustomer(Customer Customer);
    Customer updateCustomer(Long id, Customer updatedCustomer);
    void deleteCustomer(Long id);

//    void setCustomer(Customer Customer);
}
