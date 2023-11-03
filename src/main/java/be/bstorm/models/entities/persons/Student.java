package be.bstorm.models.entities.persons;

import be.bstorm.models.entities.Branch;
import be.bstorm.models.entities.Person;
import be.bstorm.models.entities.StudentCourse;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@NoArgsConstructor @AllArgsConstructor
public class Student extends Person {

    //On gere la bidirrectionalité du coté de student pour pouvoir recuperer les cours depuis les etudiants
    @OneToMany(mappedBy = "student")
    private Set<StudentCourse> studentCourseSet;

    @ManyToOne
    private Branch branch;

    //Principe de copie defensive. On prefere renvoyer une copie de la list pour des raisons de securité
    public Set<StudentCourse> getStudentCourseSet(){
        return Set.copyOf(this.studentCourseSet);
    }

    //Etant donné que le get renvoi une copie. On doit quand meme etre capable dajouter un element a la liste
    public void addStudentCourse(StudentCourse studentCourse){
        this.studentCourseSet.add(studentCourse);
        //Quand on rajoute l'inscription a l etudiant on en profite pour rajouter l etudiant a l inscription
        studentCourse.setStudent(this);
    }

    //Pareil pour la suppression
    public void removeStudentCourse(StudentCourse studentCourse){
        this.studentCourseSet.remove(studentCourse);
    }
}
