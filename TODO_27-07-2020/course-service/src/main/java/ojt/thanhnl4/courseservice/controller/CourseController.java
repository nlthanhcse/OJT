package ojt.thanhnl4.courseservice.controller;

import ojt.thanhnl4.courseservice.model.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private List<Course> courses = Arrays.asList(
            new Course("1", "Course 1", 1),
            new Course("2", "Course 2", 2),
            new Course("3", "Course 3", 3),
            new Course("4", "Course 4", 4),
            new Course("5", "Course 5", 5)
    );

    @GetMapping("/course/{courseId}")
    public Course getById(@PathVariable(name = "courseId") String courseId) {
        return this.courses
                .stream()
                .filter(course -> course.getCourseId().equals(courseId))
                .findFirst()
                .get();
    }
}
