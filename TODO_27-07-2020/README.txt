Microservices with Spring Boot:

	restcontroller:
		semester-info-service:  port-8080
			api: /semester-info
				get: /
					return all information of  all all student and course of
					each student

		student-service:        port-8081
			api: /students
				get: /student/{studentId}
					return a student by student id

		course-service:         port-8082
			api: /courses
				get: /course/{courseId}
					return a course by course id

		student-course-service: port-8083 
			api: /student-course
				get: /
					return StudentCourseWrapper Model that contains list of StudentCourse Model
	
	model:
		Student: 
			studentId: string, 
			name: string
		Course: 
			courseId: string, 
			name: string
		StudentCourse: 
			studentId: string, 
			courseId: string
		StudentCourseWrapper: 
			studentCourses: list<StudentCourse>
		SemesterInfo:
			student: Student,
			courses: list<Course>

Using RestTemplate to get data from another microservice.

