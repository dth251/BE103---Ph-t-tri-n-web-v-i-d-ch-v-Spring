package org.example.session04.Service;

import org.example.session04.dto.Request.InstructorCreateRequest;
import org.example.session04.entity.Instructor;
import org.example.session04.repository.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {
    private final InstructorRepository instructorRepository;

    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    // Lấy tất cả giảng viên
    public List<Instructor> findAllInstructors() {
        return instructorRepository.findAll();
    }

    // Tìm giảng viên theo ID
    public Instructor findInstructorById(Long id) {
        Optional<Instructor> optionalInstructor = instructorRepository.findById(id);
        return optionalInstructor.orElse(null);
    }

    // Tạo mới giảng viên từ DTO
    public Instructor createInstructor(InstructorCreateRequest req) {
        Instructor instructor = new Instructor();

        // Map dữ liệu từ DTO sang Entity
        instructor.setName(req.getName());
        instructor.setEmail(req.getEmail());
        // Gọi save() của instructorRepository (JPA tự hiểu đây là tạo mới vì ID đang là null)
        return instructorRepository.save(instructor);
    }
}
