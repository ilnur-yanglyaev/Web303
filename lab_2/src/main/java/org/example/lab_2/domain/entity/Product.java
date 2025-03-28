package org.example.lab_2.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.util.List;

@Entity
@Table(name = "product_tab", schema = "eq_shop")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")  // Соответствие столбцу в БД
    @Comment("Идентификатор товара")
    private Long id;

    @Column(name = "PRODUCT_NAME", nullable = false, length = 200)
    @Comment("Наименование товара")
    private String name;

    @ManyToOne
    @JoinColumn(name = "MANUFACTURER_ID", nullable = false)
    @Comment("Идентификатор производителя. Внешний ключ к manufacturer_tab.id")
    private Manufacturer manufacturer;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    @Comment("Идентификатор категории. Внешний ключ к category_tab.id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<Delivery> deliveries;

    @OneToMany(mappedBy = "product")
    private List<PurchaseItem> purchaseItems;


//    @OneToMany(mappedBy = "product")
//    private List<PriceChange> priceChanges;
//
}