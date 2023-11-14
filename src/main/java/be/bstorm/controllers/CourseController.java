package be.bstorm.controllers;

import be.bstorm.models.dtos.course.CourseDTO;
import be.bstorm.models.entities.Course;
import be.bstorm.models.forms.CourseForm;
import be.bstorm.services.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<Course> create(@RequestBody @Valid CourseForm form){
        Course course = courseService.create(form.toEntity());
        return ResponseEntity.ok(course);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> findById(@PathVariable String id){
        Course course = courseService.findById(id);
        CourseDTO dto = CourseDTO.fromEntity(course);
        return ResponseEntity.ok(dto);
    }
}
