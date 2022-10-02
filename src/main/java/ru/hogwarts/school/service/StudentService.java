package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.StudentRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }
    public Student findStudent (long id){
        return studentRepository.findById(id).get();
    }
    public Student editeStudent(Student student){
        return studentRepository.save(student);
    }
    public void deleteStudent(long id){
        studentRepository.deleteById(id);

    }
    public Collection<Student> findByAgeBetween(Integer min, Integer max){
        return studentRepository.findByAgeBetween(10,20);
    }
    public Collection<Student> findAll(){
        return studentRepository.findAll();
    }

    public List<Student> findAllByName(String name){
        return studentRepository.findAllByName(name);
    }


}
