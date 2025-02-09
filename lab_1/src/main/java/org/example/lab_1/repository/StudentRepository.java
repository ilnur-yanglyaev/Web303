package org.example.lab_1.repository;

import org.example.lab_1.domain.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
