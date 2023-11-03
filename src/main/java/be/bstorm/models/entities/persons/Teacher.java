package be.bstorm.models.entities.persons;

import be.bstorm.models.entities.Person;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor @AllArgsConstructor
public class Teacher extends Person {

    @Column(nullable = false,length = 50)
    private String title;
}
