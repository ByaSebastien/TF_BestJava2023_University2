package be.bstorm.models.entities.persons;

import be.bstorm.models.entities.Person;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Objects;

@Entity
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode
public class Teacher extends Person {

    @Column(nullable = false,length = 50)
    @Getter @Setter
    private String title;

    @Override
    public String toString() {
        return "Teacher{" +
                super.toString() +
                "title='" + title + '\'' +
                " }";
    }

    //Ce que @EqualsAndHashCode Genere
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//        Teacher teacher = (Teacher) o;
//        return Objects.equals(title, teacher.title);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(super.hashCode(), title);
//    }
}
