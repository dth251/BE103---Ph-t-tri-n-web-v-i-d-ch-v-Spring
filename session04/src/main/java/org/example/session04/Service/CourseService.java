package org.example.session04.Service;

import org.example.session04.dto.Request.CourseCreateRequest;
import org.example.session04.dto.Request.CourseUpdateRequest;
import org.example.session04.entity.Course;
import org.example.session04.entity.Instructor;
import org.example.session04.repository.CourseRepository;
import org.example.session04.repository.InstructorRepository;
import org.springframework.stereotype.Service;

    @Service
    public class CourseService {

        private final CourseRepository courseRepository;
        private final InstructorRepository instructorRepository;

        public CourseService(CourseRepository courseRepository, InstructorRepository instructorRepository) {
            this.courseRepository = courseRepository;
            this.instructorRepository = instructorRepository;
        }

        public void createCourse(CourseCreateRequest req) {
            Instructor instructor = instructorRepository.findById(req.getInstructorId())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy Giảng viên với ID: " + req.getInstructorId()));

            Course course = new Course();
            course.setTitle(req.getTitle());
            course.setStatus(req.getStatus());
            course.setInstructor(instructor); // Set đối tượng Instructor vào Course

            courseRepository.save(course);
        }

        public void updateCourse(Long id, CourseUpdateRequest req) {
            Course course = courseRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy Khóa học với ID: " + id));

            Instructor instructor = instructorRepository.findById(req.getInstructorId())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy Giảng viên với ID: " + req.getInstructorId()));

            course.setTitle(req.getTitle());
            course.setStatus(req.getStatus());
            course.setInstructor(instructor);

            courseRepository.save(course);
        }
}
