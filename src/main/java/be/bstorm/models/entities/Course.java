package be.bstorm.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@NoArgsConstructor @AllArgsConstructor
public class Course extends BaseEntity<String>{

    @Column(length = 50,nullable = false,unique = true)
    private String name;

    private String summary;

    //Si on voulait gerer la bidirectionalité
//    @ManyToMany(mappedBy = "courses")
//    private Set<Branch> branches;
}
