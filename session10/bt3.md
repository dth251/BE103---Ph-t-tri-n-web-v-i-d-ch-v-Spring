# Bài tập 3: Thiết kế tài nguyên phức tạp (Complex Resources)

Tài liệu này trình bày cách thiết kế API cho các tài nguyên có quan hệ phân cấp (Parent-Child) trong hệ thống quản lý bệnh viện.

## 1. Nguyên tắc áp dụng
- **Cấu trúc:** `/resources/{id}/sub-resources`
- **Mối quan hệ:** Thể hiện rõ tài nguyên con (Child) thuộc về tài nguyên cha (Parent) nào thông qua đường dẫn URL.

## 2. Thiết kế API Endpoints

| STT | Yêu cầu nghiệp vụ | HTTP Method | API Endpoint |
| :--- | :--- | :--- | :--- |
| 1 | Lấy tất cả lịch hẹn của một bác sĩ cụ thể | **GET** | `/doctors/{doctorId}/appointments` |
| 2 | Lấy một đơn thuốc cụ thể của một bệnh nhân | **GET** | `/patients/{patientId}/prescriptions/{prescriptionId}` |
| 3 | Thêm một đơn thuốc mới cho bệnh nhân | **POST** | `/patients/{patientId}/prescriptions` |

## 3. Mô tả chi tiết

### Lấy lịch hẹn theo bác sĩ
- **Endpoint:** `/doctors/{doctorId}/appointments`
- **Mô tả:** Trả về danh sách các cuộc hẹn được gán cho bác sĩ có ID tương ứng.

### Quản lý đơn thuốc theo bệnh nhân
- **Lấy chi tiết:** `/patients/{patientId}/prescriptions/{prescriptionId}`
  - API này đảm bảo tính bảo mật và logic: Đơn thuốc phải thuộc về đúng bệnh nhân đó mới có thể truy cập.
- **Tạo mới:** `POST /patients/{patientId}/prescriptions`
  - Khi tạo mới, `patientId` trên URL xác định chủ sở hữu của đơn thuốc, dữ liệu chi tiết về thuốc sẽ nằm trong Request Body.

---
