package com.fashionlike.proyecto_fashion_like.app.usecase.auth.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterRequestDTO {
    private String name;
    private String mail;
    private String password;
    private String username;
}
