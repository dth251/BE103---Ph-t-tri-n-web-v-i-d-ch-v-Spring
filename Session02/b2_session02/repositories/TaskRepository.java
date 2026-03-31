package org.example.b2_session02.repositories;

import org.example.b2_session02.models.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {
    private final List<Task> tasks = new ArrayList<>();

    public TaskRepository(){
        tasks.add(new Task(1L, "Thiết kế Database", "Vẽ ERD cho hệ thống", "high", 1L));
        tasks.add(new Task(2L, "Khởi tạo Project", "Setup Spring Boot và các dependency", "high", 2L));
        tasks.add(new Task(3L, "Tạo Entity", "Sử dụng Lombok cho User và Task", "high", 2L));
        tasks.add(new Task(4L, "Viết Repository", "Tạo class mock data", "medium", 3L));
        tasks.add(new Task(5L, "Viết Service", "Xử lý logic và gọi Repository", "medium", 3L));
        tasks.add(new Task(6L, "Viết Controller", "Tạo RESTful API Endpoint", "high", 2L));
        tasks.add(new Task(7L, "Test API", "Sử dụng Postman để gọi thử", "medium", 1L));
        tasks.add(new Task(8L, "Viết Document", "Tạo file design.md", "low", 3L));
        tasks.add(new Task(9L, "Fix Bug", "Kiểm tra lỗi khởi tạo Bean", "high", 1L));
        tasks.add(new Task(10L, "Review Code", "Kiểm tra lại toàn bộ source code", "medium", 1L));
    }
        public List<Task> findAll(){
        return tasks;
        }

}
