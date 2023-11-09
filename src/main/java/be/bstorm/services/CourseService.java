package be.bstorm.services;

import be.bstorm.models.entities.Course;

import java.util.List;

public interface CourseService {

    Course create(Course course);

    Course findById(String id);

    List<Course> findAll();
}
