package org.example.lab_2.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.eclipse.persistence.annotations.JoinFetch;
import org.eclipse.persistence.annotations.JoinFetchType;
import org.hibernate.annotations.Comment;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Entity
@Table(name = "purchase_item_tab", schema = "eq_shop")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PurchaseItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
////    @JoinColumn(name = "purchase_id")
//    @JoinFetch(JoinFetchType.OUTER)
//    private Purchase purchase;

    @Comment("Количество товара")
    @Column(name = "product_count", nullable = false)
    private Integer productCount;

    @Comment("Цена товара в копейках")
    @Column(name = "product_price", nullable = false, precision = 19, scale = 2)
    private BigDecimal productPrice;


    @OneToMany
//    @MapsId("productId")  // Ссылается на поле productId в PurchaseItemId
    @JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(name = "fk_product"))
    private List<Product> products;
}









