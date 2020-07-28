package ojt.thanhnl4.semesterinfoservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourseWrapper {
    private List<StudentCourse> studentCourses;
}
