package be.bstorm.services.impl;

import be.bstorm.models.entities.Branch;
import be.bstorm.models.entities.Course;
import be.bstorm.repositories.BranchRepository;
import be.bstorm.repositories.CourseRepository;
import be.bstorm.services.BranchService;
import org.springframework.stereotype.Service;

@Service
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;
    private final CourseRepository courseRepository;

    public BranchServiceImpl(BranchRepository branchRepository, CourseRepository courseRepository) {
        this.branchRepository = branchRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public Branch create(Branch branch) {

        if(branchRepository.existsByName(branch.getName())){
            throw new RuntimeException();
        }
        branch.setId(branch.getName() + "007");
        return branchRepository.save(branch);
    }

    @Override
    public void addCourse(String branchId, String courseId) {
        Branch branch = branchRepository.findById(branchId).orElseThrow();
        Course course = courseRepository.findById(courseId).orElseThrow();
        branch.addCourse(course);
        branchRepository.save(branch);
    }
}
