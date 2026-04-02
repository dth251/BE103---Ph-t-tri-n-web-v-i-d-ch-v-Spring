package org.example.session04.Service;

import org.example.session04.entity.Course;
import org.example.session04.entity.Student;
import org.example.session04.entity.StudentEnrollment;
import org.example.session04.repository.CourseRepository;
import org.example.session04.repository.StudentEnrollmentRepository;
import org.example.session04.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentEnrollmentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final StudentEnrollmentRepository enrollmentRepository;

    public StudentEnrollmentService(StudentRepository studentRepository, CourseRepository courseRepository, StudentEnrollmentRepository enrollmentRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    public void enrollStudent(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Sinh viên với ID: " + studentId));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Khóa học với ID: " + courseId));

        StudentEnrollment enrollment = new StudentEnrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        enrollmentRepository.save(enrollment);
    }
}
