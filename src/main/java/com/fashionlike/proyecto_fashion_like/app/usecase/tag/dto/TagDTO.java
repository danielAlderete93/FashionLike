package com.fashionlike.proyecto_fashion_like.app.usecase.tag.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TagDTO {
    private Integer id;
    private String name;
    private List<Integer> tagsId;
}
