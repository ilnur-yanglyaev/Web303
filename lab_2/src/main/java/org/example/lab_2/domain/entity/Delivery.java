package org.example.lab_2.domain.entity;


import jakarta.persistence.*;
import org.eclipse.persistence.annotations.JoinFetch;
import org.eclipse.persistence.annotations.JoinFetchType;
import org.hibernate.annotations.Comment;
import lombok.*;
import java.sql.Timestamp;
import java.util.List;

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



    //    @Comment("Идентификатор товара. Внешний ключ к product_tab.id")
    @OneToMany(mappedBy = "delivery")
    @JoinFetch(JoinFetchType.OUTER)
    //    @JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(name = "fk_product"))
    private List<Product> products;



//    @Comment("Идентификатор филиала. Внешний ключ к store_tab.id")
//    @ManyToOne
////    @JoinColumn(name = "store_id")
//   @JoinFetch(JoinFetchType.OUTER)
//    private Storere storere;





    @Comment("Количество товара")
    @Column(name = "product_count", nullable = false)
    private Integer productCount;
}
