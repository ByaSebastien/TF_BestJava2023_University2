package be.bstorm.models.entities;

import be.bstorm.models.entities.persons.Teacher;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@NoArgsConstructor @AllArgsConstructor
@ToString(of = {"name","summary"}) @EqualsAndHashCode(of = {"name","summary"})
public class Course extends BaseEntity<String>{

    @Column(length = 50,nullable = false,unique = true)
    @Getter @Setter
    private String name;

    @Getter @Setter
    private String summary;

    @ManyToOne(fetch = FetchType.EAGER)
    @Getter @Setter
    private Teacher teacher;

    //Si on voulait gerer la bidirectionalité
//    @ManyToMany(mappedBy = "courses")
//    private Set<Branch> branches;


    public Course(String name, String summary) {
        this.name = name;
        this.summary = summary;
    }
}
