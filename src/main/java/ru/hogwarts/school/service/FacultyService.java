package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repositories.FacultyRepository;
import ru.hogwarts.school.repositories.StudentRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Service
public class FacultyService {
    Logger logger = LoggerFactory.getLogger(FacultyService.class);

    private FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        logger.debug("Создание Факультета: {}",faculty);
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) {
        logger.debug("Нахождения факультета по id : {}", id);
     return facultyRepository.findById(id).get();
    }

    public Faculty editeFaculty(Faculty faculty) {
        logger.debug("Добавление факультета : {}", faculty);
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
        logger.debug("Удаление факультета по id : {}", id);
        facultyRepository.deleteById(id);
    }
    public Collection<Faculty> getAll(){
        logger.debug("Получнение всех факультетов");
        return facultyRepository.findAll();
    }

    public Collection<Faculty> findAllByColor(String color){
        logger.debug("Получение всех факультетов по цвету: {}", color);
        return facultyRepository.findAllByColor(color);
    }
public List<Faculty> findByNameAndColor(String name, String color){
        logger.debug("Нахождение по имени и цвету факультета : {}" , name , color);
        return findByNameAndColor(name,color);
}
}
