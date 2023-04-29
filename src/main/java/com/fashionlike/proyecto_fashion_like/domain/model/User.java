package com.fashionlike.proyecto_fashion_like.domain.model;

import com.fashionlike.proyecto_fashion_like.domain.model.role.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    private Long id;
    private String name;
    private String username;
    private String password;
    private Boolean isActive;
    private Role rol;
}
