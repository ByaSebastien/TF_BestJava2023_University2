package be.bstorm.exceptions.course;

public class CourseAlreadyExistException extends RuntimeException{

    public CourseAlreadyExistException() {
        super("A course with this name already exist.");
    }

    public CourseAlreadyExistException(String message) {
        super(message);
    }
}
