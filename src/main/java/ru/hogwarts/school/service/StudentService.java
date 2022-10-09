package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.StudentRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    Logger logger = LoggerFactory.getLogger(StudentService.class);
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student){
        logger.debug("Создание студента :{} ",student);
        return studentRepository.save(student);
    }
    public Student findStudent (long id){
        logger.debug("Поиск студента по id :{} ",id);
        return studentRepository.findById(id).get();
    }
    public Student editeStudent(Student student){
        logger.debug("Добавление студента :{} ",student);
        return studentRepository.save(student);
    }
    public void deleteStudent(long id){
        logger.debug("Удаление студента по id :{} ",id);
        studentRepository.deleteById(id);

    }
    public Collection<Student> findByAgeBetween(Integer min, Integer max){
        logger.debug("Поиск студентов в диапазоте  : от {} до {} ", min , max);
        return studentRepository.findByAgeBetween(10,20);
    }
    public Collection<Student> findAll(){
        logger.debug("Поиск всех студентов студента");
        return studentRepository.findAll();
    }

    public List<Student> findAllByName(String name){
        logger.debug("Поиск студента по имени :{} ",name);
        return studentRepository.findAllByName(name);
    }

    public Collection<String> getAllStudentFilteredByName(){
        return studentRepository.findAll().stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .filter(s->s.startsWith("А"))
                .sorted()
                .collect(Collectors.toList());
    }

    public Double getAllStudentAvAge(){
        return studentRepository.findAll()
                .stream()
                .mapToInt((Student::getAge))
                .average()
                .orElse(0);
    }


}
