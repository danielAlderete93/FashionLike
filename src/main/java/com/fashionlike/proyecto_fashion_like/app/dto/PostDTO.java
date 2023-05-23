package com.fashionlike.proyecto_fashion_like.app.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class PostDTO {
    private Integer id;
    private String title;
    private String img;
    private String description;
    private Date date;
    private Long views;
    private Integer idAuthor;
    private Boolean isActive;
    private List<Integer> idTags;
}