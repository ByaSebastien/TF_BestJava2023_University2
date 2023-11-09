package be.bstorm.models.dtos.course;

import be.bstorm.models.entities.Course;

public record CourseShortDTO(
        String id,
        String name
) {
    public static CourseShortDTO fromEntity(Course course){
        return new CourseShortDTO(course.getId(), course.getName());
    }
}
