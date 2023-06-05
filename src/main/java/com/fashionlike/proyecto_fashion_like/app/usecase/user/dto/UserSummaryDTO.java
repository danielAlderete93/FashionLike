package com.fashionlike.proyecto_fashion_like.app.usecase.user.dto;

import com.fashionlike.proyecto_fashion_like.domain.model.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserSummaryDTO {
    private String name;
    private String username;
    private String mail;
    private Role role;
}