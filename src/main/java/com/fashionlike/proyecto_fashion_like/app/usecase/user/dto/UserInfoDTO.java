package com.fashionlike.proyecto_fashion_like.app.usecase.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInfoDTO {
    private Integer id;
    private String name;
    private Boolean isActive;
}
