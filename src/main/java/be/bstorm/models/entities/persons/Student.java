package be.bstorm.models.entities.persons;

import be.bstorm.models.entities.Branch;
import be.bstorm.models.entities.Person;
import be.bstorm.models.entities.StudentCourse;
import be.bstorm.models.entities.embedded.Address;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@DiscriminatorValue("STUDENT")
public class Student extends Person {

    //On gere la bidirrectionalité du coté de student pour pouvoir recuperer les cours depuis les etudiants
    @OneToMany(
            mappedBy = "student",
            fetch = FetchType.LAZY,
//            cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REMOVE}
            cascade = CascadeType.ALL )
    private Set<StudentCourse> studentCourseSet;

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter
    @Setter
    private Branch branch;

    //Constructor vide custom pour s'assurer que notre set de studentCourse soit tjs instancié
    public Student() {
        this.studentCourseSet = new HashSet<>();
    }

    public Student(String id,String firstname, String lastname,String username,String password,String role, Address address) {
        //this() fait appel au constructeur vide de Student
        this();
        this.setId(id);
        this.setFirstname(firstname);
        this.setLastname(lastname);
        this.setUsername(username);
        this.setPassword(password);
        this.setRole(role);
        this.setAddress(address);
    }

    //Principe de copie defensive. On prefere renvoyer une copie de la list pour des raisons de securité
    public Set<StudentCourse> getStudentCourseSet() {
        return Set.copyOf(this.studentCourseSet);
    }

    //Etant donné que le get renvoi une copie. On doit quand meme etre capable dajouter un element a la liste
    public void addStudentCourse(StudentCourse studentCourse) {
        this.studentCourseSet.add(studentCourse);
        //Quand on rajoute l'inscription a l etudiant on en profite pour rajouter l etudiant a l inscription
        studentCourse.setStudent(this);
    }

    //Pareil pour la suppression
    public void removeStudentCourse(StudentCourse studentCourse) {
        this.studentCourseSet.remove(studentCourse);
    }

    @Override
    public String toString() {
        return "Student{ " + super.toString() + " }";
    }
}
