package be.bstorm.utils;

import be.bstorm.models.entities.Person;
import be.bstorm.models.entities.embedded.Address;
import be.bstorm.models.entities.persons.Student;
import be.bstorm.repositories.security.AuthRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(AuthRepository authRepository, PasswordEncoder passwordEncoder) {
        this.authRepository = authRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        String password = passwordEncoder.encode("Test1234=");
        Person p = new Person("Seb","Bya","Bambino",password,"ADMIN",true,
                new Address("Rue ceriser","18","4000","Liege","Belgium"));
        p.setId("ADMIN");
        authRepository.save(p);
        Student st = new Student("IDST","jean","Baptiste","JB",password,"STUDENT",
                new Address("Rue ceriser","18","4000","Liege","Belgium"));
        st.setId("STUDENT");
        authRepository.save(st);
    }
}
