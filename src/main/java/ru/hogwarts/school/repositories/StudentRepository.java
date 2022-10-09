package ru.hogwarts.school.repositories;

import liquibase.pro.packaged.S;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Collection<Student> findByAgeBetween(Integer min, Integer max);

    List<Student> findAllByName(String name);

    @Query(value = "SELECT COUNT(*) FROM Student", nativeQuery = true)
    Long getAmountOfAllStudents();

    @Query(value = "SELECT AVG(age) FROM Student", nativeQuery = true)
    Long getAverageOfAllStudents();

    @Query(value = "SELECT * FROM Student ORDER BY id DESC LIMIT 5", nativeQuery = true)
    Long getLastFiveOfAllStudents();


}

