package be.bstorm.services.security;

import be.bstorm.models.entities.Person;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {

    Person register(Person p);
    Person login(String username,String password);
}
