# Phân tích yêu cầu: Xem danh sách sản phẩm

## 1. Client (Trình duyệt)

Khi người dùng muốn xem danh sách sản phẩm, trình duyệt sẽ gửi HTTP
Request đến server.

-   **URL dự kiến:**

        http://localhost:8080/products

-   **HTTP Method:**\
    `GET`

-   **Giải thích:**\
    Vì đây là thao tác lấy dữ liệu (read-only), không làm thay đổi trạng
    thái hệ thống nên sử dụng phương thức GET theo đúng nguyên tắc
    RESTful.

------------------------------------------------------------------------

## 2. Server (Spring Boot Application)

Khi nhận được request, ứng dụng Spring Boot sẽ:

### Bước 1: Controller tiếp nhận request

``` java
@GetMapping("/products")
public List<Product> getAllProducts() {
    return productService.getAllProducts();
}
```

### Bước 2: Service xử lý logic nghiệp vụ

``` java
public List<Product> getAllProducts() {
    return productRepository.findAll();
}
```

### Bước 3: Repository truy xuất dữ liệu

-   Nếu dùng JPA:

``` java
public interface ProductRepository extends JpaRepository<Product, Long> {
}
```

------------------------------------------------------------------------

## 3. Database (Giả lập bằng RAM)

Trong bài toán này, ta giả lập database bằng bộ nhớ RAM.

Ví dụ:

``` java
private List<Product> products = Arrays.asList(
    new Product(1L, "Laptop", 1500),
    new Product(2L, "Phone", 800),
    new Product(3L, "Keyboard", 100)
);
```

Vai trò của Database:

-   Lưu trữ dữ liệu sản phẩm
-   Trả dữ liệu cho server khi được yêu cầu
-   Trong thực tế có thể dùng MySQL, PostgreSQL...
-   Trong ví dụ này dữ liệu nằm trong bộ nhớ (RAM)

------------------------------------------------------------------------

## 4. Response (Server trả về gì?)

Có 2 trường hợp phổ biến:

### Trường hợp 1: REST API

Server trả về **JSON**:

``` json
[
  {
    "id": 1,
    "name": "Laptop",
    "price": 1500
  },
  {
    "id": 2,
    "name": "Phone",
    "price": 800
  }
]
```

→ Phù hợp khi frontend là React, Angular, Vue...

------------------------------------------------------------------------

### Trường hợp 2: Server-side rendering (Thymeleaf)

Server trả về **HTML**:

``` html
<table>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Price</th>
  </tr>
  <tr>
    <td>1</td>
    <td>Laptop</td>
    <td>1500</td>
  </tr>
</table>
```

→ Phù hợp khi dùng Spring MVC + Thymeleaf.

------------------------------------------------------------------------

# Tổng kết luồng xử lý

Client (GET /products)\
→ Controller (Spring Boot)\
→ Service (Xử lý nghiệp vụ)\
→ Repository\
→ Database (RAM hoặc DB thật)\
→ Server trả JSON hoặc HTML\
→ Client hiển thị danh sách sản phẩm
