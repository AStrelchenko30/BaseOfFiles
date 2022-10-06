package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("{id}")
    public Faculty getFaculty(@PathVariable long id) {
        return facultyService.findFaculty(id);

    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @PutMapping
    public Faculty editeFaculty(@RequestBody Faculty faculty) {
        return facultyService.editeFaculty(faculty);
    }

    @DeleteMapping("{id}")
    public void deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
    }

    @GetMapping
    public ResponseEntity<Collection<Faculty>> getAllFaculty() {
        return ResponseEntity.ok(facultyService.getAll());
    }

    @GetMapping(params = {"name","color"})
    public ResponseEntity<List<Faculty>> findByNameAndColor(@RequestParam("name") String name,@RequestParam("color")
    String color) {
        return ResponseEntity.ok(facultyService.findByNameAndColor(name,color));
    }
}
