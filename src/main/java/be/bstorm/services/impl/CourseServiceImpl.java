package be.bstorm.services.impl;

import be.bstorm.exceptions.course.CourseAlreadyExistException;
import be.bstorm.models.entities.Course;
import be.bstorm.repositories.CourseRepository;
import be.bstorm.services.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course create(Course course) {
        if (courseRepository.existsByName(course.getName())) {
            throw new CourseAlreadyExistException();
        }
        String mnemo;
        do {
            Random rng = new Random();
            mnemo = course.getName().substring(0, 2) + rng.nextInt(10, 100);
        }while (courseRepository.existsById(mnemo));

        course.setId(mnemo);
        return courseRepository.save(course);
    }
}
