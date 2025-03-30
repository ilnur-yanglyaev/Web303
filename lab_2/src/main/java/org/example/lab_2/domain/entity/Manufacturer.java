package org.example.lab_2.domain.entity;
import jakarta.persistence.*;
import lombok.*;
import org.eclipse.persistence.annotations.JoinFetch;
import org.eclipse.persistence.annotations.JoinFetchType;
import org.hibernate.annotations.Comment;

import java.util.List;

@Entity
@Table(name = "manufacturer_tab",schema = "eq_shop")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("Идентификатор производителя")
    private Long id;

    @Column(name = "name", nullable = false, length = 150)
    @Comment("Наименование производителя")
    private String name;

    @OneToMany(mappedBy = "manufacturer")
//    @JoinFetch(JoinFetchType.OUTER)
    private List<Product> products;
}
