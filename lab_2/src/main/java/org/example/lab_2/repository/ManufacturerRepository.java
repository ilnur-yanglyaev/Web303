package org.example.lab_2.repository;

import org.example.lab_2.domain.dto.manufacturer.ManufacturerDataDto;
import org.example.lab_2.domain.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
    @Query(value =
            "WITH TotalSales AS (" +
                    "    SELECT SUM(product_count) AS total_sales " +
                    "    FROM eq_shop.purchase_items_tab" +
                    "), " +
                    "ManufacturerSales AS (" +
                    "    SELECT " +
                    "        m.name AS manufacturer_name, " +
                    "        SUM(pi.product_count) AS count " +
                    "    FROM eq_shop.purchase_items_tab pi " +
                    "    JOIN eq_shop.product_tab p ON pi.product_id = p.id " +
                    "    JOIN eq_shop.manufacturer_tab m ON p.manufacturer_id = m.id " +
                    "    GROUP BY m.name" +
                    ") " +
                    "SELECT " +
                    "    ms.manufacturer_name AS manufacturerName, " +
                    "    ms.count AS count, " +
                    "    cast(ROUND((CAST(ms.count AS NUMERIC) / NULLIF(ts.total_sales, 0) * 100), 2) AS DOUBLE PRECISION )AS percent " +
                    "FROM ManufacturerSales ms " +
                    "CROSS JOIN TotalSales ts " +
                    "ORDER BY ms.count DESC",
            nativeQuery = true
    )
    List<ManufacturerDataDto> getManufacturerData();



    @Query(value = "SELECT COALESCE(SUM(product_count), 0) AS total_products_sold " +
            "FROM eq_shop.purchase_items_tab", nativeQuery = true)
    Long getTotal();
}

