package be.bstorm.models.forms;

import be.bstorm.models.entities.Course;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CourseForm {

    @NotBlank
    @Size(min = 2,max = 50)
    private String name;

    @Size(max = 255)
    private String summary;

    public Course toEntity(){
        return new Course(this.name,this.summary);
    }
}
