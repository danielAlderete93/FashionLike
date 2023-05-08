package com.fashionlike.proyecto_fashion_like.domain.model;

import com.fashionlike.proyecto_fashion_like.domain.model.role.Role;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {
    private Long id;
    private String name;
    private String username;
    private String password;
    private Boolean isActive;
    private Role rol;
}
