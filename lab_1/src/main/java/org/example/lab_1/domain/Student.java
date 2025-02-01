package org.example.lab_1.domain;
import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String faculty;
    private Integer group;
}

