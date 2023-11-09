package be.bstorm.models.dtos.course;

import be.bstorm.models.entities.Course;

public record CourseDTO(
        String id,
        String name,
        String summary
) {

    public static CourseDTO fromEntity(Course course){
        return new CourseDTO(course.getId(), course.getName(), course.getSummary());
    }
}
