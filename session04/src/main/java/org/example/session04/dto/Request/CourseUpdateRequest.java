package org.example.session04.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.session04.entity.CourseStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CourseUpdateRequest {
    private String title;
    private CourseStatus status;
    private Long instructorId;

}
