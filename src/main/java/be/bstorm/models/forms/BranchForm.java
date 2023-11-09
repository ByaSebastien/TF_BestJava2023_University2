package be.bstorm.models.forms;

import be.bstorm.models.entities.Branch;
import lombok.Data;

import java.util.Set;

@Data
public class BranchForm {

    private String name;

    private Set<String> courseIds;

    public Branch toEntity(){
        return new Branch(this.name);
    }
}
