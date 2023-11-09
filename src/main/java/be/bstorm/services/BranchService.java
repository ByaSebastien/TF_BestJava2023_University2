package be.bstorm.services;

import be.bstorm.models.entities.Branch;
import be.bstorm.models.entities.Course;

public interface BranchService {

    Branch create(Branch branch);

    void addCourse(String branchId, String courseId);
}
