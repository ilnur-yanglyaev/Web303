package org.example.lab_2.domain.entity;

import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "purchase_item_tab", schema = "eq_shop")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseItem {

    @Id
    @Comment("Идентификатор покупки. Внешний ключ к purchase_tab.id. Часть составного PK")
    @Column(name = "purchase_id", nullable = false)
    private Long purchaseId;

    @Id
    @Comment("Идентификатор продукта. Внешний ключ к product_tab.id. Часть составного PK")
    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Comment("Количество товара")
    @Column(name = "product_count", nullable = false)
    private Integer productCount;

    @Comment("Цена товара в копейках")
    @Column(name = "product_price", nullable = false, precision = 19, scale = 2)
    private BigDecimal productPrice;



    // Связи
    @ManyToOne
    @JoinColumn(name = "purchase_id", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "fk_purchase"))
    private Purchase purchase; // Связь с сущностью Purchase

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "fk_product"))
    private Product product; // Связь с сущностью Product
}
