package org.example.lab_1.service.impl;

import org.example.lab_1.domain.Student;
import org.example.lab_1.service.StudentService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.example.lab_1.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    @Autowired
    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll(); // Получаем всех студентов из базы данных
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> student = repository.findById(id); // Ищем студента по ID
        return student.orElse(null); // Возвращаем студента или null, если не найден
    }

    @Override
    public Student addStudent(Student student) {
        return repository.save(student); // Сохраняем студента в базе данных
    }

    @Override
    public Student updateStudent(Long id, Student updatedStudent) {
        Optional<Student> optionalStudent = repository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            if (updatedStudent.getFirstName() != null) {
                student.setFirstName(updatedStudent.getFirstName());
            }
            if (updatedStudent.getLastName() != null) {
                student.setLastName(updatedStudent.getLastName());
            }
            if (updatedStudent.getFatherName() != null) {
                student.setFatherName(updatedStudent.getFatherName());
            }
            if (updatedStudent.getGroup() != null) {
                student.setGroup(updatedStudent.getGroup());
            }
            if (updatedStudent.getFaculty() != null) {
                student.setFaculty(updatedStudent.getFaculty());
            }
            return repository.save(student); // Сохраняем обновленного студента
        }
        return null; // Если студент не найден, возвращаем null
    }

    @Override
    public void deleteStudent(Long id) {
        repository.deleteById(id); // Удаляем студента по ID
    }

    @Override
    public void setStudent(Student student) {
        repository.save(student); // Сохраняем студента
    }

}

