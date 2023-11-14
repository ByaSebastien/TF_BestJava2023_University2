package be.bstorm.models.forms.auth;

import be.bstorm.models.entities.Person;
import be.bstorm.models.entities.embedded.Address;
import be.bstorm.models.entities.persons.Student;
import be.bstorm.models.entities.persons.Teacher;
import lombok.Data;

@Data
public class RegisterForm {

    private String id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String type;
    private Address address;
    private String title;

    public Person toEntity(){
        switch (this.type){
            case "STUDENT":
                return new Student(id,firstname,lastname,username,password,type,address);
            case "TEACHER":
                return new Teacher(firstname,lastname,username,password,type,address,title);
            default:
                throw new RuntimeException();
        }
    }
}
