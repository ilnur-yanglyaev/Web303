package org.example.lab_1.controller;

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
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    // GET: Получить студента по ID
    @GetMapping("/{id}/student")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return student != null ? ResponseEntity.ok(student) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

//    @GetMapping("/{id}/student")
//    public ResponseEntity<String> getStudentById(@PathVariable Long id) {
//        Student student = studentService.getStudentById(id);
//        if (student != null) {
//            return ResponseEntity.ok(student.toString()); // Если студент найден, возвращаем его данные
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Студент не найден."); // Возвращаем сообщение об ошибке
//        }
//    }

    // POST: Добавить нового студента
    @PostMapping("/student")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(student));
    }

    // PUT: Обновить студента
    @PutMapping("/{id}/student")
    public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        Student student = studentService.updateStudent(id, updatedStudent);
        if (student != null) {
            return ResponseEntity.ok("Студент успешно обновлён."); // Возвращаем строку с сообщением
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Студент не найден."); // Возвращаем сообщение об ошибке
        }}

    // DELETE: Удалить студента
    @DeleteMapping("/student")
    public ResponseEntity<String> deleteStudent(@RequestParam Long id) {
        // Проверяем, существует ли студент с данным идентификатором
        Student student = studentService.getStudentById(id);

        if (student != null) {
            // Если студент найден, удаляем его
            studentService.deleteStudent(id);
            return ResponseEntity.ok("Студент успешно удалён.");
        } else {
            // Если студент не найден, возвращаем 404 Not Found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Студент не найден.");
        }
    }

}
