package be.bstorm.controllers;

import be.bstorm.models.entities.Course;
import be.bstorm.models.forms.CourseForm;
import be.bstorm.services.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<Course> create(@RequestBody CourseForm form){
        Course course = courseService.create(form.toEntity());
        return ResponseEntity.ok(course);
    }
}
