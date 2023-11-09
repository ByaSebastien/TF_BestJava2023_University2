package be.bstorm.exceptions.course;

public abstract class CourseException extends RuntimeException{

    public CourseException(String message) {
        super(message);
    }
}
