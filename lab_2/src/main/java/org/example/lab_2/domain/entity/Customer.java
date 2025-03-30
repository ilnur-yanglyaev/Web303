package org.example.lab_2.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer_tab", schema = "eq_shop")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Comment("Идентификатор покупателя")
    private Long id;

    @Comment("Имя покупателя")
    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Comment("Фамилия покупателя")
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Comment("Отчество покупателя")
    @Column(name = "middle_name", length = 100)
    private String middleName;


//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//    private List<Purchase> purchases;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
