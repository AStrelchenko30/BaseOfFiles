package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("{id}")
    public Student getStudentInfo(@PathVariable Long id){
        Student student=studentService.findStudent(id);
        return student;
    }
    @PostMapping
    public Student creatStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }
    @PutMapping
    public Student editStudent(@RequestBody Student student){
        return studentService.editeStudent(student);
    }
    @DeleteMapping("{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<Collection<Student>> findAllStudent(@RequestParam(required = false) Integer min,
                                                              @RequestParam(required = false) Integer max){
        return ResponseEntity.ok(studentService.findAll());
    }
}
