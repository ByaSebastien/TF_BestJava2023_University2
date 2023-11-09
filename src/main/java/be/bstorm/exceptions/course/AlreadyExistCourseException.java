package be.bstorm.exceptions.course;

public class AlreadyExistCourseException extends CourseException{

    public AlreadyExistCourseException() {
        super("A course with this name already exist.");
    }

    public AlreadyExistCourseException(String message) {
        super(message);
    }
}
