package org.example.lab_2.domain.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.Comment;
import lombok.*;
import java.sql.Timestamp;

@Entity
@Table(name = "delivery_tab",schema = "eq_shop")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("Идентификатор")
    private Long id;

    @Comment("Дата поставки")
    @Column(name = "delivery_date", nullable = false)
    private Timestamp deliveryDate;

    @Comment("Идентификатор товара. Внешний ключ к product_tab.id")
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(name = "fk_product"))
    private Product product; // Связь с сущностью Product

    @Comment("Идентификатор филиала. Внешний ключ к store_tab.id")
    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false, foreignKey = @ForeignKey(name = "fk_store"))
    private Store store; // Связь с сущностью Store

    @Comment("Количество товара")
    @Column(name = "product_count", nullable = false)
    private Integer productCount;
}
