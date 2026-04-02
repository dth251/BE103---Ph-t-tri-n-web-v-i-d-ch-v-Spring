package org.example.session04.Service;

import org.example.session04.dto.Request.StudentCreateRequest;
import org.example.session04.entity.Student;
import org.example.session04.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    // Sử dụng Constructor Injection
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Tạo mới sinh viên
    public void createStudent(StudentCreateRequest req) {
        Student student = new Student();

        // Map dữ liệu từ Request DTO sang Entity
        student.setName(req.getName());
        student.setEmail(req.getEmail());

        // Lưu xuống cơ sở dữ liệu
        studentRepository.save(student);
    }
}
