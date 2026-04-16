# Bài tập: Chuẩn hóa mã lỗi HTTP cho Hệ thống Y tế

Dưới đây là bảng phân loại mã lỗi cho các tình huống nghiệp vụ cụ thể.

## Bảng mã lỗi HTTP (Status Codes)

| Tình huống | Status Code | Lý do |
| :--- | :--- | :--- |
| **Bỏ trống tên bệnh nhân** | `400 Bad Request` | Yêu cầu thiếu dữ liệu bắt buộc (Missing required fields). |
| **ID bệnh án không tồn tại** | `404 Not Found` | Tài nguyên yêu cầu không có trong hệ thống. |
| **Lỗi kết nối MySQL** | `500 Internal Server Error` | Sự cố phát sinh từ phía máy chủ/hạ tầng. |
| **Dữ liệu tuổi âm (-5)** | `422 Unprocessable Entity` | Dữ liệu sai logic nghiệp vụ (Validation failed). |

---
