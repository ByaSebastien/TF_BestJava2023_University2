package be.bstorm.controllers;

import be.bstorm.exceptions.course.CourseAlreadyExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Annotation requise pour l advisor
@ControllerAdvice
//Permet les logs
@Slf4j
//Controller qui permet de gerer globalement toutes les exceptions de notre appli.
public class ControllerAdvisor {

    //Methode qui gere les CourseAlreadyExistException
    @ExceptionHandler(CourseAlreadyExistException.class)
    public ResponseEntity<Object> handleCourseAlreadyExistException(CourseAlreadyExistException exception){
        return ResponseEntity.status(400).body(exception.getMessage());
//        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
