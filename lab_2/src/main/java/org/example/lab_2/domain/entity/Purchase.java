package org.example.lab_2.domain.entity;

import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "purchase_tab", schema = "eq_shop")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("Идентификатор покупки")
    private Long id;

    @Comment("Дата покупки")
    @Column(name = "purchase_date", nullable = false)
    private Timestamp purchaseDate;

    @Comment("Идентификатор покупателя. Внешний ключ к customer_tab.id")
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false, foreignKey = @ForeignKey(name = "fk_customer"))
    private Customer customer;

    @Comment("Идентификатор филиала. Внешний ключ к store_tab.id")
    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false, foreignKey = @ForeignKey(name = "fk_store"))
    private Store store;



    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL)
    private List<PurchaseItem> items = new ArrayList<>();


}