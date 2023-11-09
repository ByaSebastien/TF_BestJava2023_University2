package be.bstorm.repositories;

import be.bstorm.models.entities.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch,String> {

    boolean existsByName(String name);
}
