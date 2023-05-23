package com.fashionlike.proyecto_fashion_like.app.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TagDTO {
    private Integer id;
    private String name;
    private List<TagDTO> tags;
}
