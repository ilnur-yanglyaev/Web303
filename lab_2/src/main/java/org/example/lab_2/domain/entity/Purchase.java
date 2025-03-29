package org.example.lab_2.domain.entity;

import lombok.*;
import org.eclipse.persistence.annotations.JoinFetch;
import org.eclipse.persistence.annotations.JoinFetchType;
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
    @Column(name = "purchase_id")
    @Comment("Идентификатор покупки")
    private Long purchase_id;

    @Comment("Дата покупки")
    @Column(name = "purchase_date", nullable = false)
    private Timestamp purchaseDate;

    @Comment("Идентификатор покупателя. Внешний ключ к customer_tab.id")
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false, foreignKey = @ForeignKey(name = "fk_customer"))
    private Customer customer;

    @OneToMany(mappedBy = "purchase")
    @JoinFetch(JoinFetchType.OUTER)
    private List<PurchaseItem> items = new ArrayList<>();


}