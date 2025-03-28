package org.example.lab_2.repository;

import org.example.lab_2.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT c FROM CUSTOMER c JOIN FETCH c.purchases WHERE c.id = :customerId")
    Optional<Customer> findByIdWithPurchases(@Param("customerId") Long customerId);
}