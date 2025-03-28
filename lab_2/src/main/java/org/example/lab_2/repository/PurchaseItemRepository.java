package org.example.lab_2.repository;

import org.example.lab_2.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseItemRepository extends JpaRepository<PurchaseItem, Long> {
}
