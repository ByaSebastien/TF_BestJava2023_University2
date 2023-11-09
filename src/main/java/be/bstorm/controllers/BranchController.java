package be.bstorm.controllers;

import be.bstorm.models.entities.Branch;
import be.bstorm.models.entities.Course;
import be.bstorm.models.forms.BranchForm;
import be.bstorm.services.BranchService;
import be.bstorm.services.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/branch")
public class BranchController {

    private final BranchService branchService;
    private final CourseService courseService;

    public BranchController(BranchService branchService, CourseService courseService) {
        this.branchService = branchService;
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<Branch> create(@RequestBody @Valid BranchForm form){
        Branch newBranch = form.toEntity();
        for (String courseId : form.getCourseIds()){
            Course course = courseService.findById(courseId);
            newBranch.addCourse(course);
        }
        Branch branch = branchService.create(newBranch);
        return ResponseEntity.ok(branch);
    }

    @PutMapping
    public ResponseEntity<Object> addCourse(
            @RequestParam String branchId,
            @RequestParam String courseId){
        branchService.addCourse(branchId,courseId);
        return ResponseEntity.status(200).body("Accepted");
    }
}
