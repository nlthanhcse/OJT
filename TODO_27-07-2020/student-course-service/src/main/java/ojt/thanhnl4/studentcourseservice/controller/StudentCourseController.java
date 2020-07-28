package ojt.thanhnl4.studentcourseservice.controller;

import ojt.thanhnl4.studentcourseservice.model.StudentCourse;
import ojt.thanhnl4.studentcourseservice.model.StudentCourseWrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/student-courses")
public class StudentCourseController {
    private List<StudentCourse> studentCourses = Arrays.asList(
            new StudentCourse("1", "2"),
            new StudentCourse("1", "3"),
            new StudentCourse("2",  "1"),
            new StudentCourse("2", "5"),
            new StudentCourse("2", "4")
    );

    @GetMapping("/")
    public StudentCourseWrapper getAll() {
        return new StudentCourseWrapper(this.studentCourses);
    }
}
