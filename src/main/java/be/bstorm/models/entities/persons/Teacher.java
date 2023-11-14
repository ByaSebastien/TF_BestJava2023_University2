package be.bstorm.models.entities.persons;

import be.bstorm.models.entities.Person;
import be.bstorm.models.entities.embedded.Address;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Objects;

@Entity
@DiscriminatorValue("TEACHER")
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode
public class Teacher extends Person {

    @Column(length = 50)
    @Getter @Setter
    private String title;

    @Override
    public String toString() {
        return "Teacher{" +
                super.toString() +
                "title='" + title + '\'' +
                " }";
    }

    public Teacher(String firstname, String lastname, String username, String password, String role,Address address, String title) {
        super(firstname, lastname, username, password, role,true,address);
        this.title = title;
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
