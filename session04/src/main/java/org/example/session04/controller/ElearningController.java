package org.example.session04.controller;

import org.example.session04.dto.Request.*;
import org.example.session04.Service.InstructorService;
import org.example.session04.Service.CourseService;
import org.example.session04.Service.StudentService;
import org.example.session04.Service.StudentEnrollmentService;
import org.example.session04.dto.Response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ElearningController {

    private final InstructorService instructorService;
    private final CourseService courseService;
    private final StudentService studentService;
    private final StudentEnrollmentService enrollmentService;

    public ElearningController(InstructorService instructorService, CourseService courseService,
                               StudentService studentService, StudentEnrollmentService enrollmentService) {
        this.instructorService = instructorService;
        this.courseService = courseService;
        this.studentService = studentService;
        this.enrollmentService = enrollmentService;
    }

    // 1. Tạo Giảng viên
    @PostMapping("/instructors")
    public ResponseEntity<ApiResponse<Void>> createInstructor(@RequestBody InstructorCreateRequest req) {
        instructorService.createInstructor(req);
        return ResponseEntity.ok(new ApiResponse<>("Tạo Giảng viên thành công", null));
    }

    // 2. Tạo Khóa học
    @PostMapping("/courses")
    public ResponseEntity<ApiResponse<Void>> createCourse(@RequestBody CourseCreateRequest req) {
        courseService.createCourse(req);
        return ResponseEntity.ok(new ApiResponse<>("Tạo Khóa học thành công", null));
    }

    // 3. Cập nhật Khóa học
    @PutMapping("/courses/{id}")
    public ResponseEntity<ApiResponse<Void>> updateCourse(@PathVariable Long id, @RequestBody CourseUpdateRequest req) {
        courseService.updateCourse(id, req);
        return ResponseEntity.ok(new ApiResponse<>("Cập nhật Khóa học thành công", null));
    }

    // 4. Tạo Sinh viên
    @PostMapping("/students")
    public ResponseEntity<ApiResponse<Void>> createStudent(@RequestBody StudentCreateRequest req) {
        studentService.createStudent(req);
        return ResponseEntity.ok(new ApiResponse<>("Tạo Sinh viên thành công", null));
    }

    // 5. Gắn Sinh viên vào Khóa học
    @PostMapping("/students-enrollments")
    public ResponseEntity<ApiResponse<Void>> enrollStudent(@RequestBody EnrollmentRequest req) {
        enrollmentService.enrollStudent(req.getStudentId(), req.getCourseId());
        return ResponseEntity.ok(new ApiResponse<>("Đăng ký khóa học thành công", null));
    }
}
