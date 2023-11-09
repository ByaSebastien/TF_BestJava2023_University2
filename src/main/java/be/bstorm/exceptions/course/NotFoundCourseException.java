package be.bstorm.exceptions.course;

public class NotFoundCourseException extends CourseException{

    public NotFoundCourseException() {
        super("Course not found");
    }

    public NotFoundCourseException(String message) {
        super(message);
    }
}
