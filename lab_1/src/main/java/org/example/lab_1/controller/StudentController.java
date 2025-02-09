package org.example.lab_1.controller;

import org.example.lab_1.repository.StudentRepository;
import org.example.lab_1.service.StudentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.example.lab_1.domain.Student;

import java.util.List;
@RestController
@RequestMapping("/api/v1")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    // GET: Получить студента по ID
    @GetMapping("/{id}/student")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return student != null ? ResponseEntity.ok(student) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // POST: Добавить нового студента
    @PostMapping("/student")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        try {
            studentService.addStudent(student); // Используем метод addStudent
            return ResponseEntity.status(HttpStatus.CREATED).body("Студент добавлен");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ошибка: " + e.getMessage());
        }
    }

    // PUT: Обновить студента
    @PutMapping("/{id}/student")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        Student student = studentService.updateStudent(id, updatedStudent);
        if (student != null) {
            return ResponseEntity.ok(student); // Возвращаем обновленного студента
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // DELETE: Удалить студента
    @DeleteMapping("/student")
    public ResponseEntity<String> deleteStudent(@RequestParam Long id) {
        Student student = studentService.getStudentById(id);

        if (student != null) {
            studentService.deleteStudent(id);
            return ResponseEntity.ok("Студент успешно удалён.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Студент не найден.");
        }
    }
}

