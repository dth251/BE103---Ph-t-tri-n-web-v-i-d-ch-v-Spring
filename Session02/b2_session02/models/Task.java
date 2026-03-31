package org.example.b2_session02.models;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Task {
    private Long id;
    private String title;
    private String description;
    private String priority;
    private Long assigneeId;
}
