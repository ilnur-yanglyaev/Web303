package org.example.lab_2.service.impl;

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
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl{

    private final CustomerRepository customerRepository;

    public CustomerInfoDto getCustomerInfo(Long customerId) {
            // Шаг 1: Получить информацию о клиенте
            Customer customer = customerRepository.findById(customerId)
                    .orElseThrow(() -> new IllegalArgumentException("Customer with ID " + customerId + " not found"));
            // Шаг 2: Получить данные о покупках клиента
            List<Object[]> purchaseData = customerRepository.getCustomerPurchaseData(customerId);
            // Шаг 3: Преобразовать данные в DTO
            List<CustomerPurchaseDto> customerPurchaseData = new ArrayList<>();
            CustomerPurchaseDto currentPurchase = null;
            for (Object[] row : purchaseData) {
                Long purchaseId = ((Integer) row[0]).longValue();
                Timestamp purchaseDate = (Timestamp) row[1];

                String productName = (String) row[2];
                Integer count = (Integer) row[3];
                BigDecimal price = (BigDecimal) row[4];
                BigDecimal totalPrice = (BigDecimal) row[5];

                // Если текущая покупка отличается от предыдущей, создаем новую
                if (currentPurchase == null || !currentPurchase.getId().equals(purchaseId)) {
                    currentPurchase = new CustomerPurchaseDto(purchaseId, purchaseDate, new ArrayList<>());
                    customerPurchaseData.add(currentPurchase);
                }
                // Добавляем товар в текущую покупку
                currentPurchase.getItemList().add(new CustomerPurchaseItemDto(productName, count, price, totalPrice));
            }

            // Шаг 4: Собрать окончательный результат
            return new CustomerInfoDto(customer, customerPurchaseData);
        }



    public List<CustomersInfoDto> getAllCustomerWithPurchase() {
        return (customerRepository.findCustomersWithPurchase());
    }
}
