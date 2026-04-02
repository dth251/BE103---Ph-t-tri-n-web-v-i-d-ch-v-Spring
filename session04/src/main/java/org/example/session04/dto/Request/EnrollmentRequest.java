package org.example.session04.dto.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EnrollmentRequest {
    private Long studentId;
    private Long courseId;
}
