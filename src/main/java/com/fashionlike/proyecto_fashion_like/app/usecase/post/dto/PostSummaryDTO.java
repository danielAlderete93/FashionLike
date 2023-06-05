package com.fashionlike.proyecto_fashion_like.app.usecase.post.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class PostSummaryDTO {
    private Integer id;
    private String title;
    private String img;
    private String description;
    private Date date;
    private Integer views;
    private Boolean isActive;
}