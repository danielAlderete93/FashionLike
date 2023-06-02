package com.fashionlike.proyecto_fashion_like.app.dto;

import com.fashionlike.proyecto_fashion_like.domain.model.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private Integer id;
    private String name;
    private String username;
    private String password;
    private Boolean isActive;
    private Role role;
}
