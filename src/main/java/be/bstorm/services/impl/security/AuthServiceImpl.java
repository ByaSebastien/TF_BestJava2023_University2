package be.bstorm.services.impl.security;

import be.bstorm.models.entities.Person;
import be.bstorm.repositories.security.AuthRepository;
import be.bstorm.services.security.AuthService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(AuthRepository authRepository, PasswordEncoder passwordEncoder) {
        this.authRepository = authRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return authRepository.findByUsername(username).orElseThrow();
    }

    @Override
    public Person register(Person p) {
        p.setPassword(passwordEncoder.encode(p.getPassword()));
        return authRepository.save(p);
    }

    @Override
    public Person login(String username, String password) {
        Person existingPerson = authRepository.findByUsername(username).orElseThrow();
        if (!passwordEncoder.matches(password, existingPerson.getPassword())) {
            throw new RuntimeException();
        }
        return existingPerson;
    }
}
