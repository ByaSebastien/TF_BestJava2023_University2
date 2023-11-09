package be.bstorm.repositories;

import be.bstorm.models.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,String> {

    @Query("select count(c) > 0 from Course c where c.name ilike :name")
    boolean existsByName(String name);
}
