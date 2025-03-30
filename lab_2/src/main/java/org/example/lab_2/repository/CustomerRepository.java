package org.example.lab_2.repository;

import org.example.lab_2.domain.dto.customer.CustomerInfoDto;
import org.example.lab_2.domain.dto.customer.CustomerPurchaseDto;
import org.example.lab_2.domain.dto.customer.CustomersInfoDto;
import org.example.lab_2.domain.entity.Customer;
import org.example.lab_2.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT p.id AS purchaseId, " +
            "CAST(p.purchase_date AS TIMESTAMP) AS purchaseDate, " +
            "pr.name AS productName, " +
            "pi.product_count AS productCount, " +
            "pi.product_price AS productPrice, " +
            "pi.product_price * pi.product_count AS totalPrice " +
            "FROM eq_shop.purchase_tab p " +
            "JOIN eq_shop.purchase_items_tab pi ON p.id = pi.purchase_id " +
            "JOIN eq_shop.product_tab pr ON pi.product_id = pr.id " +
            "WHERE p.customer_id = :customerId",
            nativeQuery = true)
    List<Object[]> getCustomerPurchaseData(@Param("customerId") Long customerId);



    @Query(value = "SELECT c.first_name AS name, c.last_name AS secondName, COUNT(p.id) AS purchaseCount " +
            "FROM eq_shop.customer_tab c JOIN eq_shop.purchase_tab p on c.id = p.customer_id " +
            " GROUP BY c.id, c.first_name, c.last_name", nativeQuery = true)
    List<CustomersInfoDto> findCustomersWithPurchase();
}
