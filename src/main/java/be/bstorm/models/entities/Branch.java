package be.bstorm.models.entities;

import be.bstorm.models.entities.persons.Teacher;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@ToString(of = {"name"}) @EqualsAndHashCode(of = {"name"})
public class Branch extends BaseEntity<String>{

    @Column(length = 50,unique = true,nullable = false)
    @Getter @Setter
    private String name;

    @OneToOne(fetch = FetchType.EAGER)
    @Getter @Setter
    private Teacher teacher;

    //Cette annotation cree bel et bien une table intermediaire en DB
    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "toto",
//    joinColumns = @JoinColumn(name = "jc"),
//    inverseJoinColumns = @JoinColumn(name = "ijc"))
    private Set<Course> courses;

    public Branch(){
        this.courses = new HashSet<>();
    }

    public Branch(String name) {
        this();
        this.name = name;
    }

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

    //Dans le cas ou on ne veut pas tout prendre en compte : @ToString(of = {...})
//    @Override
//    public String toString() {
//        return "Branch{" +
//                "name='" + name + '\'' +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Branch branch = (Branch) o;
//        return Objects.equals(name, branch.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name);
//    }
}
