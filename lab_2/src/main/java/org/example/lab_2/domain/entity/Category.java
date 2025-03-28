package org.example.lab_2.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category_tab",schema = "eq_shop")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("Идентификатор категории")
    private Long id;

    @Column(name = "name", nullable = false, length = 150)
    @Comment("Наименование категории")
    private String name;

    @OneToMany(mappedBy = "category")  // Указываем связь один ко многим с продуктами
    private List<Product> products;   // Связь с сущностью Product

}