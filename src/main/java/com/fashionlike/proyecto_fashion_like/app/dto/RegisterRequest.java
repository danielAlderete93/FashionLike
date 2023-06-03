package com.fashionlike.proyecto_fashion_like.app.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterRequest {
    private String name;
    private String mail;
    private String password;
    private String username;
}
