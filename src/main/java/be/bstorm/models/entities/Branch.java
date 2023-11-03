package be.bstorm.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@NoArgsConstructor @AllArgsConstructor
public class Branch extends BaseEntity<String>{

    @Column(length = 50,unique = true,nullable = false)
    private String name;

    @ManyToMany
    private Set<Course> courses;

    public Set<Course> getCourses() {
        return Set.copyOf(this.courses);
    }

    public void addCourse(Course course){
        this.courses.add(course);
        //Dans le cas d'un bidirrectionalité
//        course.addBranch(this);
    }

    public void removeCourse(Course course){
        this.courses.remove(course);
        //Dans le cas d'un bidirrectionalité
//        course.removeBranch(this);
    }
}
