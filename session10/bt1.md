# Hospital Management System - API Documentation

Dự án này tuân thủ các quy tắc thiết kế RESTful API (Naming Convention) theo chuẩn Lesson 04.

## 1. Nguyên tắc thiết kế
- **Resource-based:** URL tập trung vào tài nguyên (Resources), không tập trung vào hành động.
- **Nouns over Verbs:** Sử dụng danh từ số nhiều, không sử dụng động từ trong URL.
- **HTTP Methods:** Sử dụng các phương thức HTTP để xác định hành động cụ thể trên tài nguyên.

## 2. Tài nguyên: Bác sĩ (Doctors)

Dưới đây là thiết kế các Endpoint cho tài nguyên `doctors`:

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| **GET** | `/doctors` | Lấy danh sách toàn bộ bác sĩ trong hệ thống. |
| **GET** | `/doctors/{id}` | Lấy thông tin chi tiết của một bác sĩ cụ thể theo ID. |
| **POST** | `/doctors` | Thêm một bác sĩ mới vào hệ thống. |
| **PUT** | `/doctors/{id}` | Cập nhật toàn bộ thông tin của bác sĩ dựa trên ID. |
| **DELETE** | `/doctors/{id}` | Xóa một bác sĩ khỏi hệ thống dựa trên ID. |

## 3. Ví dụ chi tiết (API Examples)

### Lấy thông tin bác sĩ có ID = 10
- **Request:** `GET https://api.hospital.com/v1/doctors/10`
- **Response:** `200 OK`

### Thêm mới một bác sĩ
- **Request:** `POST https://api.hospital.com/v1/doctors`
- **Body:** ```json
  {
    "name": "Dr. Nguyen Van A",
    "specialization": "Cardiology",
    "experience_years": 10
  }