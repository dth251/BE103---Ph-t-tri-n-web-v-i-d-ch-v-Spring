# API Design: Hệ thống Quản lý Task và User

Tài liệu này thiết kế các RESTful API Endpoint để quản lý `User` (Người dùng) và `Task` (Công việc). Mỗi công việc thuộc về một người dùng.

- **Base URL:** `/api/v1`
- **Content-Type:** `application/json`

---

## 1. Quản lý Người dùng (Users API)

| HTTP Method | Endpoint | Mô tả | Yêu cầu dữ liệu (Request Body) |
| :--- | :--- | :--- | :--- |
| **GET** | `/users` | Lấy toàn bộ danh sách người dùng. | *(Không có)* |
| **POST** | `/users` | Tạo mới người dùng. | `{"name": "Nguyen Van A", "email": "a@example.com", "role": "USER"}` |
| **PATCH** | `/users/{id}/role` | Cập nhật vai trò của người dùng. | `{"role": "ADMIN"}` |
| **DELETE** | `/users/{id}` | Xóa một người dùng khỏi hệ thống. | *(Không có)* |

---

## 2. Quản lý Công việc (Tasks API)

| HTTP Method | Endpoint | Mô tả | Yêu cầu dữ liệu (Request Body) |
| :--- | :--- | :--- | :--- |
| **GET** | `/tasks` | Lấy toàn bộ danh sách công việc. | *(Không có)* |
| **POST** | `/tasks` | Tạo mới công việc. Truyền `userId` để gán ngay. | `{"title": "Thiết kế DB", "priority": "high", "userId": 1}` |
| **PATCH** | `/tasks/{id}/status` | Cập nhật trạng thái một công việc. | `{"status": "IN_PROGRESS"}` |
| **PATCH** | `/tasks/{id}/assign` | Gắn công việc cho một người dùng. | `{"userId": 2}` |
| **DELETE** | `/tasks/{id}` | Xóa một công việc khỏi hệ thống. | *(Không có)* |

---

## 3. Lọc & Truy vấn Dữ liệu (Filtering & Sub-resources)

| HTTP Method | Endpoint | Mô tả |
| :--- | :--- | :--- |
| **GET** | `/tasks?priority=high` | Tìm các công việc có mức độ ưu tiên là "high". |
| **GET** | `/users/{id}/tasks` | Liệt kê toàn bộ công việc của 1 người dùng cụ thể. |
| **GET** | `/users/{id}/tasks?priority=high` | Tìm các công việc có độ ưu tiên là "high" và được giao cho người dùng có id tương ứng. |

---

## 4. Mục tiêu & Ghi chú Triển khai (Implementation Notes)

### 4.1. Nhận dữ liệu JSON
Sử dụng `@PostMapping` / `@PatchMapping` kết hợp với `@RequestBody` trên Controller để map dữ liệu JSON từ Client thành các đối tượng DTO (Data Transfer Object) trong Java.

### 4.2. Liên kết hai thực thể (Foreign Key Logic)
* **Mô hình:** `User` (1) - (N) `Task`.
* **Xử lý:** Khi client gửi request POST/PATCH kèm theo `userId`, tầng Service sẽ dùng `UserRepository.findById(userId)` để lấy ra thực thể User. Sau đó, gọi `task.setUser(user)` (sử dụng annotation `@ManyToOne` bên entity Task) trước khi lưu `Task` xuống database.

### 4.3. Thực hành kiểm tra dữ liệu (Validation)
Sử dụng thư viện `spring-boot-starter-validation` (các annotation `javax.validation` hoặc `jakarta.validation`):
* `@NotBlank(message = "Không được để trống")`: Áp dụng cho `title` (Task) và `name` (User).
* `@Email(message = "Email không hợp lệ")`: Áp dụng cho `email` (User).
* `@NotNull`: Áp dụng cho các trường bắt buộc như `userId`.
* Đừng quên thêm `@Valid` trước `@RequestBody` trong tham số của Controller để kích hoạt Validation.