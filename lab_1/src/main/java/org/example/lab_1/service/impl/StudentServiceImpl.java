package org.example.lab_1.service.impl;

import org.example.lab_1.domain.Student;
import org.example.lab_1.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    private List<Student> students = new ArrayList<>();
    private Long currentId = 1L; // Генерация идентификаторов

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public Student getStudentById(Long id) {
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Student addStudent(Student student) {
        student.setId(currentId++); // Генерация идентификатора
        students.add(student);
        return student;
    }

    @Override
    public Student updateStudent(Long id, Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getId().equals(id)) {
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
                return student;
            }
        }
        return null;
    }

    @Override
    public void deleteStudent(Long id) {
        students.removeIf(student -> student.getId().equals(id));
    }
}

