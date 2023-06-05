package com.fashionlike.proyecto_fashion_like.app.usecase.reactiontype.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReactionTypeDTO {
    private Integer id;
    private String name;
    private String emoji;
}
