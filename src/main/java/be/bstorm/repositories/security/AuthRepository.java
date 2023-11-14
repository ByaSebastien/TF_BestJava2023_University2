package be.bstorm.repositories.security;

import be.bstorm.models.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Person,String> {

    @Query("SELECT p FROM Person p WHERE p.username LIKE :username")
    Optional<Person> findByUsername(String username);
}
