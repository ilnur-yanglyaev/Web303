package org.example.lab_2.domain.entity;

//import jakarta.persistence.*;
import jakarta.persistence.*;
import lombok.*;

import org.eclipse.persistence.annotations.JoinFetch;
import org.eclipse.persistence.annotations.JoinFetchType;
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
    @Column(name = "id")  // Соответствие столбцу в БД
    @Comment("Идентификатор товара")
    private Long id;

    @Column(name = "name", nullable = false, length = 200)
    @Comment("Наименование товара")
    private String name;

//    private Storere store;






    @ManyToOne
//    @JoinColumn(name = "manufacturer_id", nullable = false)
    @JoinFetch(JoinFetchType.OUTER)
//    @Comment("Идентификатор производителя. Внешний ключ к manufacturer_tab.id")
    private Manufacturer manufacturer;


//    @Column(name = "category_id")
//    @Comment("Идентификатор категории. Внешний ключ к category_tab.id")
    @ManyToOne
    @JoinFetch(JoinFetchType.OUTER)
//  @JoinColumn(name = "category_id", nullable = false)
    private Category category;


    @ManyToOne
    @JoinFetch(JoinFetchType.OUTER)
//  @JoinColumn(name = "category_id", nullable = false)
    private Delivery delivery;


    @ManyToOne
    @JoinFetch(JoinFetchType.OUTER)
    private PurchaseItem purchaseItem;





//    @OneToMany(mappedBy = "product")
//    private List<PurchaseItem> purchaseItems;
//




//    @OneToMany(mappedBy = "product")
//    private List<PriceChange> priceChanges;
//
}