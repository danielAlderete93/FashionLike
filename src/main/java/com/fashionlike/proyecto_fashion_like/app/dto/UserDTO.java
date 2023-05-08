package com.fashionlike.proyecto_fashion_like.app.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private Long id;
    private String name;
    private String username;
    private String password;
    private Boolean isActive;
}
