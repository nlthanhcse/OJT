package ojt.thanhnl4.semesterinfoservice.controller;

import ojt.thanhnl4.semesterinfoservice.model.Course;
import ojt.thanhnl4.semesterinfoservice.model.SemesterInfo;
import ojt.thanhnl4.semesterinfoservice.model.Student;
import ojt.thanhnl4.semesterinfoservice.model.StudentCourseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/semester-info")
public class SemesterInfoController {
    @Autowired
    private WebClient.Builder webBuilder;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public List<SemesterInfo> display() {
        //Get list student-course
        StudentCourseWrapper studentCourses =
                this.restTemplate.getForObject("http://localhost:8083/student-courses/", StudentCourseWrapper.class);

        List<SemesterInfo> semesterInfos = new ArrayList<>();

        studentCourses
                .getStudentCourses()
                .forEach(studentCourse -> {
                    Student student = this.restTemplate.getForObject("http://localhost:8081/students/student/" + studentCourse.getStudentId(),
                            Student.class);
                    Course course = this.restTemplate.getForObject("http://localhost:8082/courses/course/" + studentCourse.getCourseId(),
                            Course.class);
                    boolean isExist = false;
                    for(SemesterInfo semInfo: semesterInfos) {
                        if (semInfo.getStudentInfo().getStudentId().equals(student.getStudentId())) {
                            List<Course> courses = semInfo.getCourses();
                            courses.add(course);
                            semInfo.setCourses(courses);
                            isExist = true;
                            break;
                        }
                    }
                    if (!isExist) {
                        List<Course> courses = new ArrayList<>();
                        courses.add(course);
                        semesterInfos.add(new SemesterInfo(student, courses));
                        isExist = false;
                    }
                });
        return semesterInfos;
    }
}
