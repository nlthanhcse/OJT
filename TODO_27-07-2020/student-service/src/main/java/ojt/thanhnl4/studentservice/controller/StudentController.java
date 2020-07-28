package ojt.thanhnl4.studentservice.controller;

import ojt.thanhnl4.studentservice.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentController {
    private List<Student> students = Arrays.asList(
            new Student("1", "Student 1"),
            new Student("2", "Student 2"),
            new Student("3", "Student 3")
    );

    @GetMapping("/student/{studentId}")
    public Student getById(@PathVariable(name = "studentId") String studentId) {
        return this.students
                .stream()
                .filter(student -> student.getStudentId().equals(studentId))
                .findFirst().get();
    }
}
