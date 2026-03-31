package org.example.b2_session02.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class User {
    private Long id;
    private String username;
    private String email;
    private String role;
}
