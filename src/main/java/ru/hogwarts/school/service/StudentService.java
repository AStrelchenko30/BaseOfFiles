package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.StudentRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    Logger logger = LoggerFactory.getLogger(StudentService.class);
    private final StudentRepository studentRepository;

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
        return studentRepository.findByAgeBetween(min,max);
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


    public Double getAverageAgeOfStudent(){
        return studentRepository.findAll()
                .stream()
                .mapToInt((Student::getAge))
                .average()
                .orElse(0);
    }

    public Faculty getFaculty(){
        return studentRepository.getFaculty();
    }
    /*public void printAllStudent(List<Student> students) {

        printAllStudent(students.subList(0,2));

        new Thread(()->{
            printAllStudent(students.subList(2,4));
        }).start();

        new Thread(()->{
            printAllStudent(students.subList(4,6));
        }).start();
    }


    public void printAllStudentSync() {
        List<Student> students=studentRepository.findAll(PageRequest.of(0,6)).getContent();
    }*/


}
