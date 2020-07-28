package ojt.thanhnl4.courseservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private String courseId;
    private String name;
    private Integer credit;
}
