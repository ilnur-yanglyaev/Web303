package org.example.lab_2.domain.entity;

import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "store_tab", schema = "eq_shop")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("Идентификатор филиала")
    private Long id;

    @Comment("Наименование филиала")
    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @OneToMany(mappedBy = "store")
    private List<Delivery> deliveries;

    @OneToMany(mappedBy = "store")    // Указываем связь один ко многим с покупками
    private List<Purchase> purchases; // Связь с сущностью Purchase

}
