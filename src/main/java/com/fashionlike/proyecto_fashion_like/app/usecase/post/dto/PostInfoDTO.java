package com.fashionlike.proyecto_fashion_like.app.usecase.post.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostInfoDTO {
    private Integer id;
    private String title;
    private Boolean isActive;
}
