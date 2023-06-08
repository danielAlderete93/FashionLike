package com.fashionlike.proyecto_fashion_like.app.usecase.auth.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequestDTO {
    String username;
    String password;
}